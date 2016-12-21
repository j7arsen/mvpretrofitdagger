package j7arsen.com.dagger.base;

import javax.inject.Inject;

import j7arsen.com.dagger.managers.DataManager;
import j7arsen.com.dagger.observable.IObserver;
import j7arsen.com.dagger.observable.TestObservable;

/**
 * Created by Arsen on 21.12.2016.
 */

public abstract class BasePresenter implements IObserver {

    @Inject
    protected TestObservable mObservable;
    @Inject
    protected DataManager mDataManager;

    public void onCreate() {
        mObservable.addObserver(this);
    }

    public void onDestroy() {
        mObservable.removeObserver(this);
        unsubscribe();
    }

    private void unsubscribe() {
        if (mDataManager != null) {
            mDataManager.unsubscribeAll();
        }
    }
}
