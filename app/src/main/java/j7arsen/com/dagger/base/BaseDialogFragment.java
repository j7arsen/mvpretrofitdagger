package j7arsen.com.dagger.base;

import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by j7ars on 07.01.2017.
 */

public abstract class BaseDialogFragment extends DialogFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //call this in onCreate() method inFragment
    //if only fragment then onSaveInstanceState and OnRestoreInstanceState make in Fragment
    public abstract void setupComponent();

}
