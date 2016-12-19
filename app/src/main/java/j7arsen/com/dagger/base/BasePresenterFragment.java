package j7arsen.com.dagger.base;

import android.os.Bundle;

/**
 * Created by arsen on 10.10.16.
 */

public abstract class BasePresenterFragment extends BaseFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //call this in onCreate() method inFragment
    //if only fragment then onSaveInstanceState and OnRestoreInstanceState make in Fragment
    public abstract void setupComponent();

}
