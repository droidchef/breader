package in.ishankhanna.breader.data.local;

import in.ishankhanna.breader.data.models.Rss;

/**
 * The memory helper serves as an In-Memory Cache and all read/writes
 * must happen to it first, <b>always!</b>. Any changes made to it based on some user action
 * must be committed back to the DB when the app is about to be killed.
 *
 * @author Ishan Khanna
 */
public class MemoryHelper implements DataHelper {

    private Rss rss;

    /**
     * This stores the number of items available in the channel.
     */
    private int itemCount;

    /**
     * This tells if the feed has any data or not.
     */
    private boolean feedHasData;

    /**
     * This tells the last time the feed received an update in memory.
     */
    private long feedLastUpdatedAt;

    private static MemoryHelper INSTANCE;

    private MemoryHelper() {
    }

    public static MemoryHelper getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new MemoryHelper();
        }

        return INSTANCE;
    }

    @Override
    public void addFeed(Rss rssFeed) {
        if (rss == null) {
            rss = rssFeed;
            setFeedItemCount(rssFeed.getChannel().getItems().size());
            setFeedLastUpdatedAt(System.currentTimeMillis());
        }
    }

    @Override
    public Rss getFeed() {

        if (rss != null) {
            return rss;
        } else {
            throw new IllegalStateException("Cache must be initialised before being queried!");
        }

    }

    @Override
    public int getFeedItemCount() {
        return itemCount;
    }

    @Override
    public boolean hasData() {
        return feedHasData;
    }

    @Override
    public long feedLastUpdatedAt() {
        return feedLastUpdatedAt;
    }

    @Override
    public void setFeedItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public void setFeedLastUpdatedAt(long feedLastUpdatedAt) {
        this.feedLastUpdatedAt = feedLastUpdatedAt;
    }


}
