package j7arsen.com.dagger.menu.interactor;

import java.util.ArrayList;

import javax.inject.Inject;

import j7arsen.com.dagger.data.MenuData;
import j7arsen.com.dagger.managers.DataManager;
import j7arsen.com.dagger.menu.IDrawerMenuContract;

/**
 * Created by arsen on 14.10.16.
 */

public class DrawerMenuInteractor implements IDrawerMenuContract.Interactor {

    private DataManager mDataManager;

    @Inject
    public DrawerMenuInteractor(DataManager dataManager){
        this.mDataManager = dataManager;
    }

    public ArrayList<MenuData> getMenuList(){
        return mDataManager.getMenuList();
    }

}