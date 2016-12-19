package j7arsen.com.dagger.second;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import j7arsen.com.dagger.R;
import j7arsen.com.dagger.app.TestApplication;
import j7arsen.com.dagger.base.BaseContainerActivity;
import j7arsen.com.dagger.base.BaseFragment;
import j7arsen.com.dagger.di.component.AppComponent;

/**
 * Created by Arsen on 06.10.2016.
 */

public class SecondActivity extends BaseContainerActivity {

    private static final String INDEX = "SecondActivity.INDEX";

    private static final String SAVE_INDEX = "SecondActivity.SAVE_INDEX";

    @Inject
    ISecondContract.Presenter mPresenter;

    private SecondFragment mSecondFragment;

    private int mIndex;

    public static void startActivity(Activity activity, int index) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(INDEX, index);
        activity.startActivity(intent);
    }

    public static void startActivity(Fragment fragment, Activity activity, int index) {
        Intent intent = new Intent(activity, SecondActivity.class);
        intent.putExtra(INDEX, index);
        fragment.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getExtras();
        mSecondFragment = getFragment();
        setupComponent();
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt(SAVE_INDEX);
        } else {
            openFragment();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVE_INDEX, mIndex);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mIndex = savedInstanceState.getInt(SAVE_INDEX);
    }

    @Override
    public void setupComponent() {
        DaggerSecondComponent.builder().appComponent((AppComponent) TestApplication.get(TestApplication.mInstance).component()).secondModule(new SecondModule(mSecondFragment, mIndex)).build().inject(this);
    }

    private void getExtras() {
        if (getIntent().getExtras() != null) {
            mIndex = getIntent().getExtras().getInt(INDEX);
        }
    }

    @Override
    protected void openFragment() {
        getFragmentManager().beginTransaction().replace(R.id.container, mSecondFragment).commit();
    }

    private SecondFragment getFragment() {
        BaseFragment baseFragment = getCurrentFragment();
        if (baseFragment != null) {
            return (SecondFragment) baseFragment;
        } else {
            return SecondFragment.newInstance();
        }
    }


}
