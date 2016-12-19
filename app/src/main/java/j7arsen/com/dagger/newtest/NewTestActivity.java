package j7arsen.com.dagger.newtest;

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

/**
 * Created by arsen on 15.12.16.
 */

public class NewTestActivity extends BaseContainerActivity {

    @Inject
    INewTestContract.Presenter mPresenter;

    private NewTestFragment mTestFragment;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, NewTestActivity.class);
        activity.startActivity(intent);
    }

    public static void startActivity(Fragment fragment, Activity activity) {
        Intent intent = new Intent(activity, NewTestActivity.class);
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
        DaggerNewTestComponent.builder().appComponent((AppComponent) TestApplication.get(TestApplication.mInstance).component()).newTestModule(new NewTestModule(mTestFragment)).build().inject(this);
    }

    @Override
    protected void openFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, mTestFragment).commit();
    }

    private NewTestFragment getFragment() {
        BaseFragment baseFragment = getCurrentFragment();
        if(baseFragment != null){
            return (NewTestFragment) baseFragment;
        }else{
            return NewTestFragment.newInstance();
        }
    }


}
