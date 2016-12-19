package j7arsen.com.dagger.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import j7arsen.com.dagger.R;
import j7arsen.com.dagger.test.TestFragment;

/**
 * Created by arsen on 24.08.16.
 */
public abstract class BaseContainerActivity extends BaseActivity {

    @Bind(R.id.navigation_bar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
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
}
