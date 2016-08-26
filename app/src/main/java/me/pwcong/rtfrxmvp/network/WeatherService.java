package me.pwcong.rtfrxmvp.network;

import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pwcong on 2016/8/26.
 */
public class WeatherService {

    private static Retrofit instance = null;
    public static synchronized Retrofit getInstance(){

        if(null==instance){
            instance=new Retrofit.Builder()
                    .baseUrl(Api.URL_WEATHER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
        return instance;

    }

    public void getWeather(String cityname, String key, Subscriber<WeatherBean> subscriber){

        getInstance().create(WeatherApi.class)
                .getNews(cityname,key,Api.TYPE_JSON)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }


}
