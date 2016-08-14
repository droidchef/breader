package in.ishankhanna.breader.ui.views.main;

import java.util.List;

import in.ishankhanna.breader.data.models.Item;
import in.ishankhanna.breader.ui.views.base.MvpView;

/**
 * @author Ishan Khanna
 */
public interface FeedListMvpView extends MvpView {

    void showProgress();

    void hideProgress();

    void addItemsToRecyclerViewAdapter(List<Item> items);

    void showRecyclerView();

    void hideRecyclerView();

}
