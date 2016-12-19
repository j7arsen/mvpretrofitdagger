package j7arsen.com.dagger.rest.observable;

/**
 * Created by arsen on 15.12.16.
 */

public interface ISubject {

    void addObserver(IObserver iObserver);

    void removeObserver(IObserver iObserver);

    void removeAllObservers();

    void notifyStartedWithAction(final int action);

    void notifySuccess(final int action, final Object o);

    void notifyFailed(final int action, Throwable e);

    boolean containObserver(IObserver iObserver);

}
