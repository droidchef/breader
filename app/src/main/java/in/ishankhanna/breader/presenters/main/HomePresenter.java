package in.ishankhanna.breader.presenters.main;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import in.ishankhanna.breader.data.events.ShowDetailStoryEvent;
import in.ishankhanna.breader.data.models.Item;
import in.ishankhanna.breader.presenters.base.BasePresenter;
import in.ishankhanna.breader.ui.views.main.HomeMvpView;

/**
 * @author Ishan Khanna
 */
public class HomePresenter extends BasePresenter<HomeMvpView> {

    public HomePresenter(Context context) {
        super(context);
    }

    public void presentFeedList() {
        getMvpView().showFeedListFragment();
    }

    @Override
    public void attachView(HomeMvpView mvpView) {
        super.attachView(mvpView);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachView() {
        EventBus.getDefault().unregister(this);
        super.detachView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ShowDetailStoryEvent showDetailStoryEvent) {

        final Item item = showDetailStoryEvent.getItem();
        getMvpView().showStoryDetailFragment(item);

    }

}
