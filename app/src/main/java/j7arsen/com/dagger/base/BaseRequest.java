package j7arsen.com.dagger.base;

import j7arsen.com.dagger.rest.RequestManager;
import j7arsen.com.dagger.rest.observable.IRequestCallback;
import j7arsen.com.dagger.rest.observable.ISubject;

/**
 * Created by arsen on 19.12.16.
 */

public abstract class BaseRequest implements IRequestCallback {

    protected RequestManager mRequestManager;
    protected ISubject mObservable;

    public BaseRequest(RequestManager manager, ISubject subject){
        this.mRequestManager = manager;
        this.mObservable = subject;
    }

}