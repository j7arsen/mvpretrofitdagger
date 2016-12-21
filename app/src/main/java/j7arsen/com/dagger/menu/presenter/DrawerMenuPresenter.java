package j7arsen.com.dagger.menu.presenter;

import javax.inject.Inject;

import j7arsen.com.dagger.data.MenuData;
import j7arsen.com.dagger.managers.DataManager;
import j7arsen.com.dagger.menu.IDrawerMenuContract;
import j7arsen.com.dagger.menu.IMenuItemClickListener;

/**
 * Created by arsen on 14.10.16.
 */

public class DrawerMenuPresenter implements IDrawerMenuContract.Presenter {

    private IDrawerMenuContract.Interactor mDrawerMenuInteractor;
    private IDrawerMenuContract.View mDrawerMenuView;
    private IMenuItemClickListener mMenuItemClickListener;

    @Inject
    DataManager mDataManager;

    @Inject
    public DrawerMenuPresenter(IDrawerMenuContract.View view, IDrawerMenuContract.Interactor interactor, IMenuItemClickListener menuItemClickListener){
        this.mDrawerMenuView = view;
        this.mDrawerMenuInteractor = interactor;
        this.mMenuItemClickListener = menuItemClickListener;
    }

    @Inject
    void setupListeners() {
        mDrawerMenuView.setPresenter(this);
    }

    public void onCreate(){
        if(mDrawerMenuInteractor != null && mDrawerMenuView != null){
            mDrawerMenuView.setMenuData(mDrawerMenuInteractor.getMenuList());
        }
    }

    @Override
    public void openScreen(MenuData data) {
        if(mMenuItemClickListener != null){
            if(data != null) {
                mMenuItemClickListener.OnMenuItemClick(data);
            }
        }

    }

    @Override
    public void onDestroy() {
        mDrawerMenuView = null;
        mDrawerMenuInteractor = null;
    }
}
