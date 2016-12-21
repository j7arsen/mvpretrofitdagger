package j7arsen.com.dagger.newtest;

import javax.inject.Inject;

import j7arsen.com.dagger.managers.DataManager;
import j7arsen.com.dagger.rest.observable.TestObservable;
import j7arsen.com.dagger.requests.GetUserNetRequest;

/**
 * Created by arsen on 15.12.16.
 */

public class NewTestInterator implements INewTestContract.Interactor {

    private DataManager mDataManager;
    private TestObservable mObservable;

    @Inject public NewTestInterator(DataManager manager, TestObservable observable){
        this.mDataManager = manager;
        this.mObservable = observable;
    }

    @Override
    public void getUser() {
        new GetUserNetRequest(mDataManager, mObservable).getUserData();
    }

}