package j7arsen.com.dagger.rest.observable;

import j7arsen.com.dagger.rest.Pair;

/**
 * Created by arsen on 15.12.16.
 */

public interface IRequestCallback {

    public void onErrorResponse( int action, Throwable e);

    public void onSuccessResponse(Pair successData);


}
