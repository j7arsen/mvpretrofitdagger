package j7arsen.com.dagger.main.test;

import j7arsen.com.dagger.base.contract.IBasePresenter;
import j7arsen.com.dagger.base.contract.IBasePresenterView;

/**
 * Created by Arsen on 06.10.2016.
 */

public interface ITestContract {
    interface View extends IBasePresenterView<Presenter> {
        void openNextScreen();
    }

    interface Presenter extends IBasePresenter{
        void clickButton();
    }

}
