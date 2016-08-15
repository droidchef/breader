package in.ishankhanna.breader.ui.views.main;

import in.ishankhanna.breader.data.models.Item;
import in.ishankhanna.breader.ui.views.base.MvpView;

/**
 * @author Ishan Khanna
 */
public interface HomeMvpView extends MvpView {

    void showFeedListFragment();

    void showStoryDetailFragment(Item item);

}
