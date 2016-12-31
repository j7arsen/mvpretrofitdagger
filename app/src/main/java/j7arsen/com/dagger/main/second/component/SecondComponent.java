package j7arsen.com.dagger.main.second.component;

import dagger.Component;
import j7arsen.com.dagger.di.component.AppComponent;
import j7arsen.com.dagger.di.scope.ViewScope;
import j7arsen.com.dagger.main.second.ISecondContract;
import j7arsen.com.dagger.main.second.module.SecondModule;
import j7arsen.com.dagger.main.second.view.SecondActivity;

/**
 * Created by Arsen on 06.10.2016.
 */
@ViewScope
@Component(dependencies = AppComponent.class, modules = SecondModule.class)
public interface SecondComponent {

    void inject(SecondActivity secondActivity);
    ISecondContract.Presenter provideSecondPresenter();

}
