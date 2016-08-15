package in.ishankhanna.breader.ui.views.main;

import in.ishankhanna.breader.data.models.Item;
import in.ishankhanna.breader.ui.views.base.MvpView;

/**
 * @author Ishan Khanna
 */
public interface StoryDetailMvpView extends MvpView {

    void showDetailedStory(Item item);

}
