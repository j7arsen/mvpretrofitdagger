package j7arsen.com.dagger.menu.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import javax.inject.Inject;

import j7arsen.com.dagger.R;
import j7arsen.com.dagger.app.TestApplication;
import j7arsen.com.dagger.base.BaseActivity;
import j7arsen.com.dagger.data.MenuData;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.menu.IDrawerMenuContract;
import j7arsen.com.dagger.menu.IMenuItemClickListener;
import j7arsen.com.dagger.menu.component.DaggerDrawerMenuComponent;
import j7arsen.com.dagger.menu.module.DrawerMenuModule;

/**
 * Created by arsen on 14.10.16.
 */

public class DrawerMenuActivity extends BaseActivity implements IMenuItemClickListener{

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    private DrawerMenuFragment mDrawerMenuFragment;

    @Inject
    IDrawerMenuContract.Presenter mDrawerMenuPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_menu);

        initView();
        initToolbar();
        createNavigationDrawer();

        setupComponent();

    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.navigation_bar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void createNavigationDrawer() {
        mDrawerMenuFragment = (DrawerMenuFragment) getFragmentManager().findFragmentById(R.id.fragment_drawer_menu);
        mDrawerMenuFragment.setUp(mDrawerLayout, mToolbar);
    }

    @Override
    public void setupComponent() {
        DaggerDrawerMenuComponent.builder().appComponent((AppComponent) TestApplication.get(TestApplication.mInstance).component()).drawerMenuModule(new DrawerMenuModule(mDrawerMenuFragment, this)).build().inject(this);
    }

    @Override
    public void OnMenuItemClick(MenuData menuData) {
        Log.i("Menu item click", "Meni item click = " + menuData.getTitle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
