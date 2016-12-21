package j7arsen.com.dagger.menu.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import j7arsen.com.dagger.R;
import j7arsen.com.dagger.app.TestApplication;
import j7arsen.com.dagger.base.BaseActivity;
import j7arsen.com.dagger.base.BaseFragment;
import j7arsen.com.dagger.data.MenuData;
import j7arsen.com.dagger.menu.IDrawerMenuContract;
import j7arsen.com.dagger.menu.adapter.DrawerMenuAdapter;

/**
 * Created by arsen on 14.10.16.
 */

public class DrawerMenuFragment extends BaseFragment implements IDrawerMenuContract.View {

    @Bind(R.id.rv_drawer_menu)
    RecyclerView rvMenu;

    private Activity mActivity;

    private IDrawerMenuContract.Presenter mDrawerMenuPresenter;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private DrawerMenuAdapter mMenuAdapter;

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
        if (activity instanceof BaseActivity) {
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
        return inflater.inflate(R.layout.fragment_drawer_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initAdapters();
        setListeners();
        mDrawerMenuPresenter.onCreate();
        mDrawerToggle.syncState();
    }

    @Override
    public void setPresenter(IDrawerMenuContract.Presenter presenter) {
        mDrawerMenuPresenter = presenter;
    }

    @Override
    public void setMenuData(ArrayList<MenuData> menuDataList) {
        if(menuDataList != null) {
            mMenuAdapter.setData(menuDataList);
        }
    }

    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar) {
        mDrawerLayout = drawerLayout;
        mToolbar = toolbar;

        mDrawerToggle = new ActionBarDrawerToggle(mActivity, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mActivity.invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mActivity.invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, 0.0f);
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    private void initAdapters() {
        mMenuAdapter = new DrawerMenuAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(TestApplication.mInstance);
        rvMenu.setLayoutManager(manager);
        rvMenu.setAdapter(mMenuAdapter);
    }

    private void setListeners() {
        mMenuAdapter.SetOnItemClickListener(new DrawerMenuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, MenuData data) {
                openScreen(data);
            }
        });
    }

    public void updateDrawer(){
        initAdapters();
        setListeners();
    }

    private void openScreen(MenuData menuData) {
        mDrawerMenuPresenter.openScreen(menuData);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mDrawerMenuPresenter.onDestroy();
    }

}
