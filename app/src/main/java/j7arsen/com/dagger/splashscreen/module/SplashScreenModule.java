package j7arsen.com.dagger.splashscreen.module;

import dagger.Module;
import dagger.Provides;
import j7arsen.com.dagger.di.scope.ViewScope;
import j7arsen.com.dagger.splashscreen.ISplashScreenContract;
import j7arsen.com.dagger.splashscreen.interactor.SplashScreenInteractor;
import j7arsen.com.dagger.splashscreen.presenter.SplashScreenPresenter;

/**
 * Created by arsen on 20.12.16.
 */
@Module
public class SplashScreenModule {

    private ISplashScreenContract.View mSplashView;

    public SplashScreenModule(ISplashScreenContract.View splashView){
        this.mSplashView = splashView;
    }

    @Provides
    @ViewScope
    ISplashScreenContract.View provideSplashView(){
        return mSplashView;
    }

    @Provides
    @ViewScope
    ISplashScreenContract.Interactor provideSplashInteractor(SplashScreenInteractor splashScreenInteractor){
        return splashScreenInteractor;
    }

    @Provides
    @ViewScope
    ISplashScreenContract.Presenter provideSplashPresenter(SplashScreenPresenter splashScreenPresenter){
        return splashScreenPresenter;
    }

}
