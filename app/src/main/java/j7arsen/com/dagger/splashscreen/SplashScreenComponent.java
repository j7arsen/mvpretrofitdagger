package j7arsen.com.dagger.splashscreen;

import dagger.Component;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.di.scope.ViewScope;

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
