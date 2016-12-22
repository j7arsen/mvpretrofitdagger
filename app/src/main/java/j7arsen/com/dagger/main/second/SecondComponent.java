package j7arsen.com.dagger.main.second;

import dagger.Component;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.di.scope.ViewScope;

/**
 * Created by Arsen on 06.10.2016.
 */
@ViewScope
@Component(dependencies = AppComponent.class, modules = SecondModule.class)
public interface SecondComponent {

    void inject(SecondActivity secondActivity);
    ISecondContract.Presenter provideSecondPresenter();

}
