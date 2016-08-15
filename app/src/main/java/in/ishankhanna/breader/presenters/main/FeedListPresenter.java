package in.ishankhanna.breader.presenters.main;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import in.ishankhanna.breader.data.DataAgent;
import in.ishankhanna.breader.data.events.FeedAvailableEvent;
import in.ishankhanna.breader.data.events.ShowDetailStoryEvent;
import in.ishankhanna.breader.data.models.Item;
import in.ishankhanna.breader.presenters.base.BasePresenter;
import in.ishankhanna.breader.ui.views.main.FeedListMvpView;

/**
 * @author Ishan Khanna
 */
public class FeedListPresenter extends BasePresenter<FeedListMvpView> {

    private DataAgent dataAgent;

    public FeedListPresenter(Context context) {
        super(context);
        dataAgent = DataAgent.getInstance();
    }

    @Override
    public void attachView(FeedListMvpView mvpView) {
        super.attachView(mvpView);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachView() {
        EventBus.getDefault().unregister(this);
        super.detachView();
    }

    public void showFeed() {
        getMvpView().showProgress();
        getMvpView().hideRecyclerView();
        dataAgent.requestRssFeed();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(FeedAvailableEvent feedAvailableEvent) {
        List<Item> items = dataAgent.getFeed().getChannel().getItems();
        getMvpView().addItemsToRecyclerViewAdapter(items);
        getMvpView().hideProgress();
        getMvpView().showRecyclerView();
    }

    public void requestDetailedStory(Item item) {
        EventBus.getDefault().post(new ShowDetailStoryEvent(item));
    }
}
