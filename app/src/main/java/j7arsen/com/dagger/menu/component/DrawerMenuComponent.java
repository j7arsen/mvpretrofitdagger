package j7arsen.com.dagger.menu.component;

import dagger.Component;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.di.scope.ViewScope;
import j7arsen.com.dagger.menu.IDrawerMenuContract;
import j7arsen.com.dagger.menu.module.DrawerMenuModule;
import j7arsen.com.dagger.menu.view.DrawerMenuActivity;

/**
 * Created by arsen on 14.10.16.
 */
@ViewScope
@Component(dependencies = AppComponent.class, modules = DrawerMenuModule.class)
public interface DrawerMenuComponent {

    void inject(DrawerMenuActivity drawerMenuActivity);
    IDrawerMenuContract.Interactor provideDrawerMenuInteractor();
    IDrawerMenuContract.Presenter provideDrawerMenuPresenter();

}
