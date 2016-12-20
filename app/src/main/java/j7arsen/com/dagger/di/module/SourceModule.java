package j7arsen.com.dagger.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import j7arsen.com.dagger.managers.DataHelper;
import j7arsen.com.dagger.managers.DataManager;
import j7arsen.com.dagger.rest.RequestManager;
import j7arsen.com.dagger.rest.observable.TestObservable;
import retrofit2.Retrofit;

/**
 * Created by arsen on 14.10.16.
 */
@Module
public class SourceModule {

    @Provides
    @Singleton
    DataHelper provideDataHelper(){
        return DataHelper.getInstance();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataHelper dataHelper){
        return DataManager.getInstance(dataHelper);
    }

    @Provides
    @Singleton
    RequestManager provideRequestManager(Retrofit retrofit){
        return RequestManager.getInstance(retrofit);
    }

    @Provides
    @Singleton
    TestObservable provideTestObservable(){
        return TestObservable.getInstance();
    }


}
