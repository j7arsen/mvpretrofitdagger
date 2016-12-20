package j7arsen.com.dagger.splashscreen;

import javax.inject.Inject;

import j7arsen.com.dagger.managers.DataManager;
import rx.Observable;

/**
 * Created by arsen on 20.12.16.
 */

public class SplashScreenInteractor implements ISplashScreenContract.Interactor {

    private DataManager mDataManager;

    @Inject public SplashScreenInteractor(DataManager dataManager){
        this.mDataManager = dataManager;
    }

    @Override
    public Observable getTimerSplash() {
        return mDataManager.getSplashTimer();
    }
}
