package j7arsen.com.dagger.splashscreen.component;

import dagger.Component;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.di.scope.ViewScope;
import j7arsen.com.dagger.splashscreen.ISplashScreenContract;
import j7arsen.com.dagger.splashscreen.module.SplashScreenModule;
import j7arsen.com.dagger.splashscreen.view.SplashScreenActivity;

/**
 * Created by arsen on 20.12.16.
 */
@ViewScope
@Component(dependencies = AppComponent.class, modules = SplashScreenModule.class)
public interface SplashScreenComponent {

    void inject(SplashScreenActivity splashScreenActivity);
    ISplashScreenContract.Interactor provideSplashInteractor();
    ISplashScreenContract.Presenter provideSplashPresenter();

}
