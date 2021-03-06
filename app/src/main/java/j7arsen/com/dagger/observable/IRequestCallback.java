package j7arsen.com.dagger.observable;

import j7arsen.com.dagger.data.Pair;

/**
 * Created by arsen on 15.12.16.
 */

public interface IRequestCallback {

    public void onErrorResponse(int action, Throwable e);

    public void onSuccessResponse(int action, Pair successData);


}
