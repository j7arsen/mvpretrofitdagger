package j7arsen.com.dagger.main.test.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import j7arsen.com.dagger.R;
import j7arsen.com.dagger.app.TestApplication;
import j7arsen.com.dagger.base.BaseContainerActivity;
import j7arsen.com.dagger.base.BaseFragment;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.main.test.DaggerTestComponent;
import j7arsen.com.dagger.main.test.ITestContract;
import j7arsen.com.dagger.main.test.module.TestModule;

/**
 * Created by Arsen on 06.10.2016.
 */

public class TestActivity extends BaseContainerActivity {

    @Inject
    ITestContract.Presenter mPresenter;

    private TestFragment mTestFragment;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, TestActivity.class);
        activity.startActivity(intent);
    }

    public static void startActivity(Fragment fragment, Activity activity) {
        Intent intent = new Intent(activity, TestActivity.class);
        fragment.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTestFragment = getFragment();
        setupComponent();
        if(savedInstanceState == null) {
            openFragment();
        }
    }

    @Override
    public void setupComponent() {
        DaggerTestComponent.builder().appComponent((AppComponent) TestApplication.get(TestApplication.mInstance).component()).testModule(new TestModule(mTestFragment)).build().inject(this);
    }

    @Override
    protected void openFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, mTestFragment).commit();
    }

    private TestFragment getFragment() {
        BaseFragment baseFragment = getCurrentFragment();
        if(baseFragment != null){
            return (TestFragment) baseFragment;
        }else{
            return TestFragment.newInstance();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
