package me.pwcong.rtfrxmvp.network;

import me.pwcong.rtfrxmvp.mvp.bean.NewsBean;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pwcong on 2016/8/22.
 */
public interface TouTiaoApi {

    @GET("/toutiao/index")
    Observable<NewsBean> getNews(@Query("type") String type, @Query("key") String key);

}
