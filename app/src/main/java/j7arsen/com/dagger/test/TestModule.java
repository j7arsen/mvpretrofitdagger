package j7arsen.com.dagger.test;

import dagger.Module;
import dagger.Provides;
import j7arsen.com.dagger.di.scope.ViewScope;

/**
 * Created by Arsen on 06.10.2016.
 */
@Module
public class TestModule {

    private ITestContract.View mTestView;

    public TestModule(ITestContract.View testView){
        mTestView = testView;
    }

    @Provides
    @ViewScope
    ITestContract.View provideTestView(){
        return mTestView;
    }

    @Provides
    @ViewScope
    ITestContract.Presenter provideTestPresenter(TestPresenter testPresenter){
        return testPresenter;
    }

}
