package me.pwcong.rtfrxmvp.network;

import me.pwcong.rtfrxmvp.mvp.bean.NewsBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pwcong on 2016/8/22.
 */
public class TouTiaoService {

    public static Retrofit retrofit = null;

    public void getNews(String type, String key, Subscriber<NewsBean> subscriber){

        if(null==retrofit){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Api.URL_TOUTIAO)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }

        retrofit.create(TouTiaoApi.class)
                .getNews(type,key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
