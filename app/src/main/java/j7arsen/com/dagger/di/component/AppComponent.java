package j7arsen.com.dagger.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import j7arsen.com.dagger.di.module.AppModule;
import j7arsen.com.dagger.di.module.NetModule;
import j7arsen.com.dagger.di.module.SourceModule;
import j7arsen.com.dagger.managers.DataHelper;
import j7arsen.com.dagger.managers.DataManager;
import j7arsen.com.dagger.rest.RequestManager;
import j7arsen.com.dagger.observable.TestObservable;
import retrofit2.Retrofit;

/**
 * Created by Arsen on 06.10.2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class, SourceModule.class})
public interface AppComponent {

    Context provideContext();
    Retrofit provideRetrofit();
    DataHelper provideDataHelper();
    DataManager provideDataManager();
    RequestManager provideRequestManager();
    TestObservable provideTestIObservable();

}
