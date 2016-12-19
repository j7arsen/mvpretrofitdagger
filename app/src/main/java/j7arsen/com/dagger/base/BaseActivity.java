package j7arsen.com.dagger.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Arsen on 06.10.2016.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //OnSaveInstanceState and OnRestoreInstanceState make in Activity, because field set in presenter from activity? fragment don`t know about this fields
    public abstract void setupComponent();

}
