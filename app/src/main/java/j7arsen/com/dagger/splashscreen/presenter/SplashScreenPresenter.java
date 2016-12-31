package j7arsen.com.dagger.splashscreen.presenter;

import javax.inject.Inject;

import j7arsen.com.dagger.splashscreen.ISplashScreenContract;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by arsen on 20.12.16.
 */

public class SplashScreenPresenter implements ISplashScreenContract.Presenter {

    private ISplashScreenContract.View mSplashView;
    private ISplashScreenContract.Interactor mSplashInteractor;

    private Subscription mSubscription = Subscriptions.empty();

    @Inject public SplashScreenPresenter(ISplashScreenContract.View splashView, ISplashScreenContract.Interactor splashInteractor){
        this.mSplashView = splashView;
        this.mSplashInteractor = splashInteractor;
    }

    @Override
    public void onCreate() {
       mSubscription = mSplashInteractor.getTimerSplash().subscribe(aLong -> openMainScreen());
    }

    private void openMainScreen(){
        unsubcribe();
        if(mSplashView != null){
            mSplashView.openMainScreen();
        }
    }

    private void unsubcribe(){
        if(!mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
    }

    @Override
    public void onDestroy() {
        unsubcribe();
        mSplashView = null;
        mSplashInteractor = null;
    }
}
