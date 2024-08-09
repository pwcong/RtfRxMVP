package me.pwcong.rtfrxmvp.mvp.model;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.JokeBean;
import me.pwcong.rtfrxmvp.mvp.bean.NewsBean;
import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;
import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import rx.Subscriber;

/**
 * Created by pwcong on 2016/8/20.
 */
public interface BaseModel<T> {

    List<T> getData();

    interface NewsFragmentTabModel extends BaseModel<NewsTab> {
    }

    interface NewsFragmentModel {
        void getData(String type, Subscriber<NewsBean> subscriber);
    }

    interface WeatherFragmentModel {
        void getData(String cityname, Subscriber<WeatherBean> subscriber);
    }

    interface JokeFragmentModel {
        void getData(int page, Subscriber<JokeBean> subscriber);
    }

}
