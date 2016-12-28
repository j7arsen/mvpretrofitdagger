package j7arsen.com.dagger.main.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import j7arsen.com.dagger.R;
import j7arsen.com.dagger.base.BaseActivity;
import j7arsen.com.dagger.base.BaseFragment;
import j7arsen.com.dagger.main.newtest.NewTestActivity;

/**
 * Created by Arsen on 06.10.2016.
 */

public class TestFragment extends BaseFragment implements ITestContract.View{

    private Activity mActivity;

    private Unbinder mUnbinder;

    private ITestContract.Presenter mPresenter;

    public static TestFragment newInstance(){
        TestFragment testFragment = new TestFragment();
        return testFragment;
    }

    @Override
    public void setPresenter(@NonNull ITestContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mActivity = (Activity) context;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof BaseActivity){
            mActivity = activity;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
    }

    @OnClick(R.id.btn_next_activity)
    void goNextScreen(){
        mPresenter.clickButton();
    }

    @Override
    public void openNextScreen() {
        NewTestActivity.startActivity(this, mActivity);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

}
