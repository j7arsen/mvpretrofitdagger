package j7arsen.com.dagger.main.newtest.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import j7arsen.com.dagger.R;
import j7arsen.com.dagger.base.BaseActivity;
import j7arsen.com.dagger.base.BaseFragment;
import j7arsen.com.dagger.data.UserData;
import j7arsen.com.dagger.error.ErrorHandler;
import j7arsen.com.dagger.error.ProgressDialogManager;
import j7arsen.com.dagger.main.newtest.INewTestContract;

/**
 * Created by arsen on 15.12.16.
 */

public class NewTestFragment extends BaseFragment implements INewTestContract.View {

    private Activity mActivity;
    private Unbinder mUnbinder;

    private INewTestContract.Presenter mPresenter;

    public static NewTestFragment newInstance(){
        NewTestFragment newTestFragment = new NewTestFragment();
        return newTestFragment;
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
        mPresenter.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_test, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void fillView(UserData userData) {
        Log.i("UserData", "UserData = " + userData.getName());
    }

    @OnClick(R.id.btn_get_user)
    void getUser(){
        mPresenter.getUserData();
    }

    @Override
    public void startLoading() {
        ProgressDialogManager.getInstance().startLoading(this);
    }

    @Override
    public void completeLoading() {
        ProgressDialogManager.getInstance().completeLoading();
    }

    @Override
    public void errorLoading(Throwable e) {
        ProgressDialogManager.getInstance().errorLoading(new ErrorHandler(e));
    }

    @Override
    public void setPresenter(INewTestContract.Presenter presenter) {
        mPresenter = presenter;
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
