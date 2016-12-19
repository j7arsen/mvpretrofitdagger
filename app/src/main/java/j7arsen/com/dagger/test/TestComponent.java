package j7arsen.com.dagger.test;

import dagger.Component;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.di.scope.ViewScope;

/**
 * Created by Arsen on 06.10.2016.
 */
@ViewScope
@Component(dependencies = AppComponent.class, modules = TestModule.class)
public interface TestComponent {

    void inject(TestActivity testActivity);
    ITestContract.Presenter provideTestPresenter();

}
