package j7arsen.com.dagger.splashscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import j7arsen.com.dagger.R;
import j7arsen.com.dagger.app.TestApplication;
import j7arsen.com.dagger.base.BaseActivity;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.test.TestActivity;

/**
 * Created by arsen on 20.12.16.
 */

public class SplashScreenActivity extends BaseActivity implements ISplashScreenContract.View{

    @Inject
    ISplashScreenContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);
        setupComponent();
        mPresenter.onCreate();
    }

    @Override
    public void setupComponent() {
        DaggerSplashScreenComponent.builder().appComponent((AppComponent) TestApplication.get(TestApplication.mInstance).component()).splashScreenModule(new SplashScreenModule(this)).build().inject(this);
    }

    @Override
    public void openMainScreen() {
        TestActivity.startActivity(this);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
