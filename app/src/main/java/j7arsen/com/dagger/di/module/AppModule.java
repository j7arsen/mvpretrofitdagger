package j7arsen.com.dagger.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Arsen on 06.10.2016.
 */
@Module
public class AppModule {

    private Context mContext;

    public AppModule(Context context){
        this.mContext = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return mContext;
    }

}
