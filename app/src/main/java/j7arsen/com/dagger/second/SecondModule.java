package j7arsen.com.dagger.second;

import dagger.Module;
import dagger.Provides;
import j7arsen.com.dagger.di.scope.ViewScope;

/**
 * Created by Arsen on 06.10.2016.
 */
@Module
public class SecondModule {

    private ISecondContract.View mSecondView;
    private int mIndex;

    public SecondModule(ISecondContract.View secondView, int index){
        this.mSecondView = secondView;
        this.mIndex = index;
    }

    @Provides
    @ViewScope
    ISecondContract.View provideSecondView(){
        return mSecondView;
    }

    @Provides
    @ViewScope
    int getIndex(){
        return mIndex;
    }


    @Provides
    @ViewScope
    ISecondContract.Presenter provideSecondPresenter(SecondPresenter secondPresenter){
        return secondPresenter;
    }

}
