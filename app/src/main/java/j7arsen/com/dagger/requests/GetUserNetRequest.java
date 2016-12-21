package j7arsen.com.dagger.requests;

import j7arsen.com.dagger.app.Action;
import j7arsen.com.dagger.base.BaseRequest;
import j7arsen.com.dagger.managers.DataManager;
import j7arsen.com.dagger.rest.Pair;
import j7arsen.com.dagger.rest.observable.ISubject;
import j7arsen.com.dagger.rest.service.GetUserService;

/**
 * Created by arsen on 19.12.16.
 */

public class GetUserNetRequest extends BaseRequest {

    public GetUserNetRequest(DataManager manager, ISubject observable){
        super(manager, observable);
    }

    @Override
    public void onErrorResponse(int action, Throwable e) {
        mObservable.notifyFailed(action, e);
    }

    @Override
    public void onSuccessResponse(Pair successData) {
        mObservable.notifySuccess(Action.GET_USER_DATA, successData);
    }

    public void getUserData(){
        mObservable.notifyStartedWithAction(Action.GET_USER_DATA);
        mDataManager.getUserData(GetUserService.class, Action.GET_USER_DATA, this);
    }

}