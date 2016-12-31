package j7arsen.com.dagger.base;

import j7arsen.com.dagger.app.Action;
import j7arsen.com.dagger.data.Pair;
import j7arsen.com.dagger.managers.DataManager;
import j7arsen.com.dagger.observable.IRequestCallback;
import j7arsen.com.dagger.observable.ISubject;

/**
 * Created by arsen on 19.12.16.
 */

public abstract class BaseRequest implements IRequestCallback {

    protected DataManager mDataManager;
    protected ISubject mObservable;

    public BaseRequest(DataManager manager, ISubject subject){
        this.mDataManager = manager;
        this.mObservable = subject;
    }

    @Override
    public void onErrorResponse(int action, Throwable e) {
        mObservable.notifyFailed(action, e);
    }

    @Override
    public void onSuccessResponse(int action, Pair successData) {
        mObservable.notifySuccess(Action.GET_USER_DATA, successData);
    }
}