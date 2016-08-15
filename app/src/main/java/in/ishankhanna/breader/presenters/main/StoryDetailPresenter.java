package in.ishankhanna.breader.presenters.main;

import android.content.Context;

import in.ishankhanna.breader.data.models.Item;
import in.ishankhanna.breader.presenters.base.BasePresenter;
import in.ishankhanna.breader.ui.views.main.StoryDetailMvpView;

/**
 * @author Ishan Khanna
 */
public class StoryDetailPresenter extends BasePresenter<StoryDetailMvpView> {

    private Item item;

    public StoryDetailPresenter(Context context, Item item) {
        super(context);
        this.item = item;
    }

    public void presentStory() {
        getMvpView().showDetailedStory(item);
    }

}
