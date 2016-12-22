package j7arsen.com.dagger.main.second;

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

/**
 * Created by Arsen on 06.10.2016.
 */

public class SecondFragment extends BaseFragment implements ISecondContract.View {

    private Activity mActivity;
    private Unbinder mUnbinder;

    private ISecondContract.Presenter mPresenter;

    public static SecondFragment newInstance(){
        SecondFragment secondFragment = new SecondFragment();
        return secondFragment;
    }

    @Override
    public void setPresenter(@NonNull ISecondContract.Presenter presenter) {
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
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState != null){
            mPresenter.onRestoreInstanceState(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mPresenter.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @OnClick(R.id.btn_exit)
    void goNextScreen(){
        mPresenter.clickExit();
    }

    @Override
    public void finishActivity() {
        mActivity.finish();
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
