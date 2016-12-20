package j7arsen.com.dagger.newtest;

import javax.inject.Inject;

import j7arsen.com.dagger.app.Action;
import j7arsen.com.dagger.data.UserData;
import j7arsen.com.dagger.rest.Pair;
import j7arsen.com.dagger.rest.observable.IObserver;
import j7arsen.com.dagger.rest.observable.TestObservable;

/**
 * Created by arsen on 15.12.16.
 */

public class NewTestPresenter implements INewTestContract.Presenter, IObserver {

    private INewTestContract.View mNewTestView;
    private INewTestContract.Interactor mNewTestInteractor;

    @Inject
    TestObservable mObservable;

    @Inject
    public NewTestPresenter(INewTestContract.View view, INewTestContract.Interactor interactor) {
        this.mNewTestView = view;
        this.mNewTestInteractor = interactor;
    }

    @Inject
    void setupListeners() {
        mNewTestView.setPresenter(this);
    }

    @Override
    public void onCreate() {
        mObservable.addObserver(this);
    }

    @Override
    public void getUserData() {
        if (mNewTestInteractor != null && mNewTestView != null) {
            mNewTestInteractor.getUser();
        }
    }

    @Override
    public void onStartRequest(int action) {
        switch (action){
            case Action.GET_USER_DATA:
                mNewTestView.startLoading();
                break;
        }
    }

    @Override
    public void onSuccess(int actionCode, Object objects) {
        switch (actionCode){
            case Action.GET_USER_DATA:
                mNewTestView.completeLoading();
                Pair pair = (Pair) objects;
                mNewTestView.fillView((UserData) pair.getValue());
                break;
        }
    }

    @Override
    public void onFail(int action, Throwable e) {
        switch (action) {
            case Action.GET_USER_DATA:
                mNewTestView.errorLoading(e);
                break;
        }
    }

    @Override
    public void destroy() {
        mObservable.removeObserver(this);
        mNewTestView = null;
        mNewTestInteractor = null;
    }
}