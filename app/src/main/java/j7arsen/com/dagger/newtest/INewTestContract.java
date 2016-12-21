package j7arsen.com.dagger.newtest;

import j7arsen.com.dagger.base.contract.IBaseInteractor;
import j7arsen.com.dagger.base.contract.IBasePresenter;
import j7arsen.com.dagger.base.contract.IBasePresenterView;
import j7arsen.com.dagger.data.UserData;

/**
 * Created by arsen on 15.12.16.
 */

public interface INewTestContract {

    interface View extends IBasePresenterView<INewTestContract.Presenter> {
        void fillView(UserData userData);

        void startLoading();
        void completeLoading();
        void errorLoading(Throwable e);
    }

    interface Presenter extends IBasePresenter{
        void onCreate();
        void getUserData();
    }

    interface Interactor extends IBaseInteractor{
        void getUser();
    }

}
