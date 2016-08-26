package me.pwcong.rtfrxmvp.network;

import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pwcong on 2016/8/26.
 */
public interface WeatherApi {

    @GET("/onebox/weather/query")
    Observable<WeatherBean> getNews(@Query("cityname") String cityname, @Query("key") String key,@Query("dtype") String dtype);

}
