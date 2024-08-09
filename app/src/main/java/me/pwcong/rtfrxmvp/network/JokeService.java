package me.pwcong.rtfrxmvp.network;

import me.pwcong.rtfrxmvp.mvp.bean.JokeBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pwcong on 2016/8/30.
 */
public class JokeService {

    private static Retrofit instance = null;

    public static synchronized Retrofit getInstance() {

        if (null == instance) {
            instance = new Retrofit.Builder()
                    .baseUrl(Api.URL_JOKE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return instance;

    }

    public void getJoke(String sort, int page, int pagesize, String time, String key, Subscriber<JokeBean> subscriber) {

        getInstance().create(JokeApi.class)
                .getJoke(sort, page, pagesize, time, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }
}
