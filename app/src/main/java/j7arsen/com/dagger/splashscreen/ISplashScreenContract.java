package j7arsen.com.dagger.splashscreen;

import j7arsen.com.dagger.base.contract.IBaseInteractor;
import j7arsen.com.dagger.base.contract.IBasePresenter;
import j7arsen.com.dagger.base.contract.IBaseView;
import rx.Observable;


/**
 * Created by arsen on 20.12.16.
 */

public interface ISplashScreenContract {

    interface View extends IBaseView {
        void openMainScreen();
    }

    interface Presenter extends IBasePresenter {
        void onCreate();
    }

    interface Interactor extends IBaseInteractor {
        Observable getTimerSplash();
    }

}
