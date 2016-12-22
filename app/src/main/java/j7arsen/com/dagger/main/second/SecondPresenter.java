package j7arsen.com.dagger.main.second;

import android.os.Bundle;

import javax.inject.Inject;

/**
 * Created by Arsen on 06.10.2016.
 */

public class SecondPresenter implements ISecondContract.Presenter {

    private static final String SAVE_INDEX = "SecondPresenter.SAVE_INDEX";

    private ISecondContract.View mSecondView;
    private int mIndex;

    @Inject
    public SecondPresenter(ISecondContract.View secondView, int index) {
        this.mSecondView = secondView;
        this.mIndex = index;
    }

    @Inject
    void setupListeners() {
        mSecondView.setPresenter(this);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVE_INDEX, mIndex);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        mIndex = savedInstanceState.getInt(SAVE_INDEX);
    }

    @Override
    public void clickExit() {
        if (mSecondView != null) {
          mIndex++;
        }
    }


    @Override
    public void onDestroy() {
        mSecondView = null;
    }
}
