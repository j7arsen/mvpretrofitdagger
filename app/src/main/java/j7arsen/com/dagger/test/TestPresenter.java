package j7arsen.com.dagger.test;

import javax.inject.Inject;

import j7arsen.com.dagger.rest.RequestManager;


/**
 * Created by Arsen on 06.10.2016.
 */

public class TestPresenter implements ITestContract.Presenter {

    @Inject
    RequestManager manager;

    private ITestContract.View mTestView;

    @Inject public TestPresenter(ITestContract.View testView){
        this.mTestView = testView;
    }

    @Inject
    void setupListeners() {
        mTestView.setPresenter(this);
    }

    @Override
    public void clickButton() {
        if(mTestView != null){
            mTestView.openNextScreen();
        }
    }

    @Override
    public void onDestroy() {
        mTestView = null;
    }
}
