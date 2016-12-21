package j7arsen.com.dagger.base;

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

}