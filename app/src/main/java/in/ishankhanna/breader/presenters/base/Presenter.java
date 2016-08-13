package in.ishankhanna.breader.presenters.base;

import in.ishankhanna.breader.ui.views.base.MvpView;

/**
 * @author Ishan Khanna
 */
public interface Presenter<V extends MvpView> {

    /**
     * Attaches the view to the presenter. So now the presenter can direct the view to perform
     * changes that it wants.
     *
     * @param mvpView The {@link MvpView} to attach to this presenter.
     */
    void attachView(V mvpView);

    /**
     * Detaches the view from the presenter. Any further calls to update the view now will result in
     * a {@link NullPointerException} so kindly refrain from doing that and call this method only
     * when you are sure No more updates onto the view or from the view are required.
     */
    void detachView();

}

