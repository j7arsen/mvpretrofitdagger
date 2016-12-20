package j7arsen.com.dagger.rest;


import java.util.concurrent.TimeUnit;

import j7arsen.com.dagger.app.Constants;
import j7arsen.com.dagger.rest.observable.IRequestCallback;
import j7arsen.com.dagger.rest.service.GetUserService;
import retrofit2.Retrofit;
import rx.Observable;
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

    public void getSplashTimer(int action, IRequestCallback requestCallback){
        mSubscription = Observable.timer(Constants.SPLASH_TIMEOUT, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(a -> successResponse(requestCallback, null), e -> onError(requestCallback, action, e));
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    public void getUserData(Class<GetUserService> serviceClass, int action, IRequestCallback requestCallback){
        mSubscription = createService(serviceClass).getUserData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(s -> successResponse(requestCallback, new Pair(s)), e -> onError(requestCallback, action, e));
        addSubscription(mSubscription);
    }

    private void successResponse(IRequestCallback callback, Pair object){
        unsubscribe(mSubscription);
        callback.onSuccessResponse(object);
    }

    private void onError(IRequestCallback callback, int action, Throwable e){
        unsubscribe(mSubscription);
        callback.onErrorResponse(action, e);
    }


    public void addSubscription(Subscription subscription) {
        mSubscriptions.add(subscription);
    }


    public void unsubscribe(Subscription subscription) {
        if(mSubscriptions.hasSubscriptions())
            if(!subscription.isUnsubscribed())
                mSubscriptions.remove(subscription);
    }


}