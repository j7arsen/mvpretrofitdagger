package j7arsen.com.dagger.newtest;

import javax.inject.Inject;

import j7arsen.com.dagger.rest.RequestManager;
import j7arsen.com.dagger.rest.observable.TestObservable;
import j7arsen.com.dagger.rest.request.GetUserRequest;

/**
 * Created by arsen on 15.12.16.
 */

public class NewTestInterator implements INewTestContract.Interactor {

    private RequestManager mRequestManager;
    private TestObservable mObservable;

    @Inject public NewTestInterator(RequestManager manager, TestObservable observable){
        this.mRequestManager = manager;
        this.mObservable = observable;
    }

    @Override
    public void getUser() {
        new GetUserRequest(mRequestManager, mObservable).getUserData();
    }

}