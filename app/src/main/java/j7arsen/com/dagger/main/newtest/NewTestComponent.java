package j7arsen.com.dagger.main.newtest;

import dagger.Component;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.di.scope.ViewScope;

/**
 * Created by arsen on 15.12.16.
 */
@ViewScope
@Component(dependencies = AppComponent.class, modules = NewTestModule.class)
public interface NewTestComponent {

    void inject(NewTestActivity testActivity);
    INewTestContract.Interactor provideNewTestInteractor();
    INewTestContract.Presenter provideNewTestPresenter();

}
