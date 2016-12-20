package j7arsen.com.dagger.splashscreen;

import javax.inject.Inject;

import j7arsen.com.dagger.rest.RequestManager;
import j7arsen.com.dagger.rest.observable.TestObservable;
import j7arsen.com.dagger.rest.request.GetSplashTimer;

/**
 * Created by arsen on 20.12.16.
 */

public class SplashScreenInteractor implements ISplashScreenContract.Interactor {

    private RequestManager mRequestManager;
    private TestObservable mObservable;

    @Inject public SplashScreenInteractor(RequestManager requestManager, TestObservable observable){
        this.mRequestManager = requestManager;
        this.mObservable = observable;
    }

    @Override
    public void getTimerSplash() {
        new GetSplashTimer(mRequestManager, mObservable).splashTimer();
    }
}
