package in.ishankhanna.breader.data;

import org.greenrobot.eventbus.EventBus;

import in.ishankhanna.breader.data.events.FeedAvailableEvent;
import in.ishankhanna.breader.data.events.FeedSyncFromNetworkFailed;
import in.ishankhanna.breader.data.local.MemoryHelper;
import in.ishankhanna.breader.data.models.Rss;
import in.ishankhanna.breader.data.remote.API;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Ishan Khanna
 */
public class DataAgent {

    public static final String TAG = DataAgent.class.getSimpleName();

    private static DataAgent INSTANCE;

    private MemoryHelper memoryHelper;

    private DataAgent() {
        memoryHelper = MemoryHelper.getInstance();
    }

    public static DataAgent getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new DataAgent();
        }

        return INSTANCE;
    }

    /**
     * Checks if memory cache has the feed and notifies the caller if it is available or requests
     * the network via API to sync latest data.
     */
    public void requestRssFeed() {
        if (memoryHelper.hasData()) {
            notifyFeedReadyForReading();
        } else {
            requestFeedFromNetwork();
        }
    }

    /**
     * Requests latest feed from the network and writes to the memory cache. After that a feed
     * available event is fired for the observers of this event.
     */
    private void requestFeedFromNetwork() {

        Call<Rss> channelCall = API.newsFeedService.getRssFeed();
        channelCall.enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                if (response.isSuccessful()) {
                    final Rss rss = response.body();
                    memoryHelper.addFeed(rss);
                    notifyFeedReadyForReading();
                } else {
                    EventBus.getDefault().post(new FeedSyncFromNetworkFailed());
                }
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                // This is a terrible failure. Like internet connection, or host down kinda thingy.
            }
        });

    }

    /**
     * Posts an event for observers that the feed is ready and can be accessed.
     */
    private void notifyFeedReadyForReading() {
        EventBus.getDefault().post(new FeedAvailableEvent());
    }

    /**
     * Returns the latest feed available in memory.
     * @return {@link Rss} feed instance.
     */
    public Rss getFeed() {
        return memoryHelper.getFeed();
    }

}
