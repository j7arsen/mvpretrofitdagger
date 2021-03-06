package j7arsen.com.dagger.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import j7arsen.com.dagger.R;

/**
 * Created by arsen on 24.08.16.
 */
public abstract class BaseContainerActivity extends BaseActivity {

    @BindView(R.id.navigation_bar)
    Toolbar toolbar;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mUnbinder = ButterKnife.bind(this);
        initToolbar();

    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }

    public BaseFragment getCurrentFragment(){
        BaseFragment baseFragment =
                (BaseFragment) getFragmentManager().findFragmentById(R.id.container);
        return baseFragment;
    }

    protected abstract void openFragment();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
