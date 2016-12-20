package j7arsen.com.dagger.managers;

import java.util.ArrayList;

import j7arsen.com.dagger.R;
import j7arsen.com.dagger.data.MenuData;

import static j7arsen.com.dagger.utils.FieldConverter.getString;

/**
 * Created by arsen on 20.12.16.
 */

public class DataHelper {

    private static DataHelper mInstance;

    private ArrayList<MenuData> mMenuList;

    private DataHelper() {
    }

    public static DataHelper getInstance() {
        if (mInstance == null) {
            mInstance = new DataHelper();
        }
        return mInstance;
    }

    public ArrayList<MenuData> getMenuList() {
        if (mMenuList == null) {
            mMenuList = generateMenuList();
        }
        return mMenuList;
    }

    private ArrayList<MenuData> generateMenuList() {
        ArrayList<MenuData> data = new ArrayList<>();

        data.add(new MenuData(MenuData.COMPANY, getString(R.string.title_menu_company)));
        data.add(new MenuData(MenuData.NEWS, getString(R.string.title_menu_news)));
        data.add(new MenuData(MenuData.CALENDAR, getString(R.string.title_menu_calendar)));
        data.add(new MenuData(MenuData.LIBRARY, getString(R.string.title_menu_library)));
        data.add(new MenuData(MenuData.MAP, getString(R.string.title_menu_map)));
        data.add(new MenuData(MenuData.BANK_REQUISITES, getString(R.string.title_menu_bank_requisites)));
        data.add(new MenuData(MenuData.SETTINGS, getString(R.string.title_menu_settings)));
        data.add(new MenuData(MenuData.HELP, getString(R.string.title_menu_help)));
        data.add(new MenuData(MenuData.ABOUT, getString(R.string.title_menu_about)));
        data.add(new MenuData(MenuData.LOGOUT, getString(R.string.title_menu_logout)));

        return data;
    }

}
