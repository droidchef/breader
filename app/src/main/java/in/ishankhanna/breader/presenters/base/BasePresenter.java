package in.ishankhanna.breader.presenters.base;

import android.content.Context;

import in.ishankhanna.breader.ui.views.base.MvpView;

/**
 * @author Ishan Khanna
 */
public class BasePresenter<V extends MvpView> implements Presenter<V> {

    private V mvpView;

    protected Context context;

    public BasePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    public V getMvpView() {
        return mvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }

}
