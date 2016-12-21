package j7arsen.com.dagger.base;

import android.app.Fragment;
import android.os.Bundle;

import javax.inject.Inject;

import j7arsen.com.dagger.rest.observable.TestObservable;

/**
 * Created by Arsen on 06.10.2016.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
