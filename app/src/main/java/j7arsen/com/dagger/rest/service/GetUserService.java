package j7arsen.com.dagger.rest.service;

import j7arsen.com.dagger.data.UserData;
import j7arsen.com.dagger.rest.Urls;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by arsen on 15.12.16.
 */

public interface GetUserService {

    @GET(Urls.GET_USER)
    Observable<UserData> getUserData();
}
