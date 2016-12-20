package j7arsen.com.dagger.rest.request;

import j7arsen.com.dagger.app.Action;
import j7arsen.com.dagger.base.BaseRequest;
import j7arsen.com.dagger.rest.Pair;
import j7arsen.com.dagger.rest.RequestManager;
import j7arsen.com.dagger.rest.observable.IRequestCallback;
import j7arsen.com.dagger.rest.observable.TestObservable;

/**
 * Created by arsen on 20.12.16.
 */

public class GetSplashTimer extends BaseRequest implements IRequestCallback{

    public GetSplashTimer(RequestManager manager, TestObservable observable){
        super(manager, observable);
    }

    @Override
    public void onErrorResponse(int action, Throwable e) {
        mObservable.notifyFailed(action, e);
    }

    @Override
    public void onSuccessResponse(Pair successData) {
        mObservable.notifySuccess(Action.SPLASH_TIMER, successData);
    }

    public void splashTimer(){
        mObservable.notifyStartedWithAction(Action.SPLASH_TIMER);
        mRequestManager.getSplashTimer(Action.SPLASH_TIMER, this);
    }

}
