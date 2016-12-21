package j7arsen.com.dagger.observable;

/**
 * Created by arsen on 15.12.16.
 */

public interface IObserver {

    void onStartRequest(final int action);

    void onSuccess(final int actionCode, Object objects);

    void onFail(int action, Throwable e);

}
