package j7arsen.com.dagger.splashscreen;

import javax.inject.Inject;

import j7arsen.com.dagger.app.Action;
import j7arsen.com.dagger.rest.observable.IObserver;
import j7arsen.com.dagger.rest.observable.TestObservable;

/**
 * Created by arsen on 20.12.16.
 */

public class SplashScreenPresenter implements ISplashScreenContract.Presenter, IObserver {

    private ISplashScreenContract.View mSplashView;
    private ISplashScreenContract.Interactor mSplashInteractor;

    @Inject
    TestObservable mObservable;

    @Inject public SplashScreenPresenter(ISplashScreenContract.View splashView, ISplashScreenContract.Interactor splashInteractor){
        this.mSplashView = splashView;
        this.mSplashInteractor = splashInteractor;
    }

    @Override
    public void onCreate() {
        mObservable.addObserver(this);
        mSplashInteractor.getTimerSplash();
    }

    @Override
    public void onStartRequest(int action) {

    }

    @Override
    public void onSuccess(int actionCode, Object objects) {
        switch (actionCode){
            case Action.SPLASH_TIMER:
                mSplashView.openMainScreen();
                break;
        }
    }

    @Override
    public void onFail(int action, Throwable e) {
    }

    @Override
    public void destroy() {
        mObservable.removeObserver(this);
        mSplashView = null;
        mSplashInteractor = null;
    }
}
