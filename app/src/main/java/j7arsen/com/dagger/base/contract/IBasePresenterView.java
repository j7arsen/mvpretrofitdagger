package j7arsen.com.dagger.base.contract;

/**
 * Created by arsen on 10.10.16.
 */

public interface IBasePresenterView<T> extends IBaseView {

    void setPresenter(T presenter);

}
