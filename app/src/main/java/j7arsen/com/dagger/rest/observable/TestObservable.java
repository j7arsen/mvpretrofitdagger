package j7arsen.com.dagger.rest.observable;

import java.util.ArrayList;

/**
 * Created by arsen on 15.12.16.
 */

public class TestObservable implements ISubject {

    private ArrayList<IObserver> mObservers;
    private static TestObservable sInstance;

    public static TestObservable getInstance() {
        if (sInstance == null) {
            sInstance = new TestObservable();
        }
        return sInstance;
    }

    private TestObservable() {
        mObservers = new ArrayList<>();
    }


    @Override
    public void addObserver(IObserver iObserver) {
        if (!mObservers.contains(iObserver)) {
            mObservers.add(iObserver);
        }
    }

    @Override
    public void removeObserver(IObserver iObserver) {
        if (iObserver != null) {
            final int i = mObservers.indexOf(iObserver);
            if (i >= 0) {
                mObservers.remove(iObserver);
            }
        }
    }

    @Override
    public void removeAllObservers() {
        if (mObservers != null) {
            mObservers.clear();
        }
    }

    @Override
    public void notifyStartedWithAction(final int action) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onStartRequest(action);
        }
    }

    @Override
    public void notifySuccess(int action, Object o) {
        for (int i = 0; i < mObservers.size(); i++) {
            mObservers.get(i).onSuccess(action, o);
        }
    }

    @Override
    public void notifyFailed(int action, Throwable e) {
        final int size = mObservers.size();
        for (int i = 0; i < size; i++) {
            mObservers.get(i).onFail(action, e);
        }
    }

    @Override
    public boolean containObserver(IObserver iObserver) {
        return mObservers.contains(iObserver);
    }

}
