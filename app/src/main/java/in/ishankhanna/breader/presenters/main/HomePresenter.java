package in.ishankhanna.breader.presenters.main;

import android.content.Context;

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


}
