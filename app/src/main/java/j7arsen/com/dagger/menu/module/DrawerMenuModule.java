package j7arsen.com.dagger.menu.module;

import dagger.Module;
import dagger.Provides;
import j7arsen.com.dagger.di.scope.ViewScope;
import j7arsen.com.dagger.menu.IDrawerMenuContract;
import j7arsen.com.dagger.menu.IMenuItemClickListener;
import j7arsen.com.dagger.menu.interactor.DrawerMenuInteractor;
import j7arsen.com.dagger.menu.presenter.DrawerMenuPresenter;

/**
 * Created by arsen on 14.10.16.
 */
@Module
public class DrawerMenuModule {

    private IDrawerMenuContract.View mDrawerMenuView;
    private IMenuItemClickListener mMenuItemClickListener;

    public DrawerMenuModule(IDrawerMenuContract.View drawerMenuView, IMenuItemClickListener menuItemClickListener){
        this.mDrawerMenuView = drawerMenuView;
        this.mMenuItemClickListener = menuItemClickListener;
    }

    @Provides
    @ViewScope
    IDrawerMenuContract.View provideDrawerMenuView(){
        return mDrawerMenuView;
    }

    @Provides
    @ViewScope
    IMenuItemClickListener provideMenuItemClickListener(){
        return mMenuItemClickListener;
    }

    @Provides
    @ViewScope
    IDrawerMenuContract.Interactor provideDrawerMenuInterator(DrawerMenuInteractor drawerMenuInteractor){
        return drawerMenuInteractor;
    }

    @Provides
    @ViewScope
    IDrawerMenuContract.Presenter provideDrawerMenuPresenter(DrawerMenuPresenter drawerMenuPresenter){
        return drawerMenuPresenter;
    }

}
