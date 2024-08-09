package me.pwcong.rtfrxmvp.network;

import me.pwcong.rtfrxmvp.mvp.bean.JokeBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pwcong on 2016/8/30.
 */
public interface JokeApi {

    @GET("/joke/content/list.from")
    Observable<JokeBean> getJoke(@Query("sort") String sort, @Query("page") int page,
            @Query("pagesize") int pagesize, @Query("time") String time,
            @Query("key") String key);
}
