package j7arsen.com.dagger.managers;

import java.util.ArrayList;

import j7arsen.com.dagger.data.MenuData;

/**
 * Created by arsen on 14.10.16.
 */

public class DataManager {

    private static DataManager mInstance;

    private DataHelper mDataHelper;

    private DataManager(DataHelper dataHelper) {
        this.mDataHelper = dataHelper;
    }

    public static DataManager getInstance(DataHelper dataHelper) {
        if (mInstance == null) {
            mInstance = new DataManager(dataHelper);
        }
        return mInstance;
    }

    public ArrayList<MenuData> getMenuList(){
        return mDataHelper.getMenuList();
    }

}
