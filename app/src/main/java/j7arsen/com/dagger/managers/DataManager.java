package j7arsen.com.dagger.managers;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import j7arsen.com.dagger.app.Constants;
import j7arsen.com.dagger.data.MenuData;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    public Observable getSplashTimer(){
        return Observable.timer(Constants.SPLASH_TIMEOUT, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public ArrayList<MenuData> getMenuList(){
        return mDataHelper.getMenuList();
    }

}
