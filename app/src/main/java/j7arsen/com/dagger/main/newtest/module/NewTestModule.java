package j7arsen.com.dagger.main.newtest.module;

import dagger.Module;
import dagger.Provides;
import j7arsen.com.dagger.di.scope.ViewScope;
import j7arsen.com.dagger.main.newtest.INewTestContract;
import j7arsen.com.dagger.main.newtest.interactor.NewTestInterator;
import j7arsen.com.dagger.main.newtest.presenter.NewTestPresenter;

/**
 * Created by arsen on 15.12.16.
 */
@Module
public class NewTestModule {

    private INewTestContract.View mNewTestView;

    public NewTestModule(INewTestContract.View testView){
        this.mNewTestView = testView;
    }

    @Provides
    @ViewScope
    INewTestContract.View provideTestView(){
        return mNewTestView;
    }

    @Provides
    @ViewScope
    INewTestContract.Interactor provideTestInteractor(NewTestInterator newTestInterator){
        return newTestInterator;
    }

    @Provides
    @ViewScope
    INewTestContract.Presenter provideTestPresenter(NewTestPresenter testPresenter){
        return testPresenter;
    }


}
