package j7arsen.com.dagger.app;

import android.app.Application;
import android.content.Context;

import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.di.component.DaggerAppComponent;
import j7arsen.com.dagger.di.module.AppModule;
import j7arsen.com.dagger.di.module.NetModule;
import j7arsen.com.dagger.di.module.SourceModule;

/**
 * Created by Arsen on 06.10.2016.
 */

public class TestApplication extends Application {

    private AppComponent mComponent;
    public static TestApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        setupDagger();
    }

    private void setupDagger(){
        mComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).netModule(new NetModule()).sourceModule(new SourceModule()).build();
    }

    public AppComponent component(){
        return mComponent;
    }

    public static TestApplication get(Context context){
        return (TestApplication) context.getApplicationContext();
    }

}
