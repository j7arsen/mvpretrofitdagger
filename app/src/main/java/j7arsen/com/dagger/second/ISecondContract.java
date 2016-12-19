package j7arsen.com.dagger.second;

import android.os.Bundle;

import j7arsen.com.dagger.base.contract.IBasePresenter;
import j7arsen.com.dagger.base.contract.IBasePresenterView;

/**
 * Created by Arsen on 06.10.2016.
 */

public interface ISecondContract {

    interface View extends IBasePresenterView<Presenter> {
        void finishActivity();
    }

    interface Presenter extends IBasePresenter{

        void onSaveInstanceState(Bundle outState);
        void onRestoreInstanceState(Bundle savedInstanceState);

        void clickExit();
    }

}
