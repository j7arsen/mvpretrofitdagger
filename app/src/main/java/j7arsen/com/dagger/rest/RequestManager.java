package j7arsen.com.dagger.rest;


import j7arsen.com.dagger.data.Pair;
import j7arsen.com.dagger.observable.IRequestCallback;
import j7arsen.com.dagger.rest.service.GetUserService;
import retrofit2.Retrofit;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by arsen on 15.12.16.
 */

public class RequestManager {

    private static RequestManager mInstance;

    private CompositeSubscription mSubscriptions = new CompositeSubscription();
    private Subscription mSubscription = Subscriptions.empty();

    private Retrofit mRetrofit;

    public static RequestManager getInstance(Retrofit retrofit) {
        if (mInstance == null) {
            mInstance = new RequestManager(retrofit);
        }
        return mInstance;
    }

    private RequestManager(Retrofit retrofit){
        this.mRetrofit = retrofit;
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    public void getUserData(Class<GetUserService> serviceClass, int action, IRequestCallback requestCallback){
        mSubscription = createService(serviceClass).getUserData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(s -> successResponse(requestCallback, new Pair(s)), e -> onError(requestCallback, e));
        addSubscription(mSubscription);
    }

    private void successResponse(IRequestCallback callback, Pair object){
        unsubscribe();
        callback.onSuccessResponse(object);
    }

    private void onError(IRequestCallback callback, Throwable e){
        unsubscribe();
        callback.onErrorResponse(e);
    }


    public void addSubscription(Subscription subscription) {
        mSubscriptions.add(subscription);
    }


    public void unsubscribe() {
        if(mSubscriptions.hasSubscriptions())
            if(!mSubscriptions.isUnsubscribed())
                mSubscriptions.remove(mSubscription);
    }

}
