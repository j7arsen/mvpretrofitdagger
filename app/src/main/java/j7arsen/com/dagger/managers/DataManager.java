package j7arsen.com.dagger.managers;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import j7arsen.com.dagger.app.Constants;
import j7arsen.com.dagger.data.MenuData;
import j7arsen.com.dagger.rest.Pair;
import j7arsen.com.dagger.rest.RequestManager;
import j7arsen.com.dagger.rest.observable.IRequestCallback;
import j7arsen.com.dagger.rest.service.GetUserService;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by arsen on 14.10.16.
 */

public class DataManager {

    private static DataManager mInstance;

    private DataHelper mDataHelper;
    private RequestManager mRequestManager;

    private DataManager(DataHelper dataHelper, RequestManager manager) {
        this.mDataHelper = dataHelper;
        this.mRequestManager = manager;
    }

    public static DataManager getInstance(DataHelper dataHelper, RequestManager manager) {
        if (mInstance == null) {
            mInstance = new DataManager(dataHelper, manager);
        }
        return mInstance;
    }

    //splash
    public Observable getSplashTimer(){
        return Observable.timer(Constants.SPLASH_TIMEOUT, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    //drawer menu
    public ArrayList<MenuData> getMenuList(){
        return mDataHelper.getMenuList();
    }

    //request
    public void getUserData(Class<GetUserService> serviceClass, int action, IRequestCallback requestCallback){
        if(mRequestManager != null){
            mRequestManager.getUserData(serviceClass, action, requestCallback);
        }
    }

    public void unsubscribeAll(){
        unsubscribeRequestManager();
    }

    private void unsubscribeRequestManager(){
        if(mRequestManager != null){
            mRequestManager.unsubscribe();
        }
    }

}
