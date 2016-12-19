package j7arsen.com.dagger.menu;

import java.util.ArrayList;

import j7arsen.com.dagger.base.contract.IBaseInteractor;
import j7arsen.com.dagger.base.contract.IBasePresenter;
import j7arsen.com.dagger.base.contract.IBasePresenterView;
import j7arsen.com.dagger.data.MenuData;

/**
 * Created by arsen on 14.10.16.
 */

public interface IDrawerMenuContract {

    interface Interactor extends IBaseInteractor{
        ArrayList<MenuData> getMenuList();
    }

    interface View extends IBasePresenterView<IDrawerMenuContract.Presenter> {
        void setMenuData(ArrayList<MenuData> menuDataList);
    }

    interface Presenter extends IBasePresenter {
        void onCreate();
        void openScreen(MenuData menuData);
    }

}
