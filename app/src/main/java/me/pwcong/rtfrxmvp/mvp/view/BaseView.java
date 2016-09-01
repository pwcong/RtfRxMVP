package me.pwcong.rtfrxmvp.mvp.view;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.Joke;
import me.pwcong.rtfrxmvp.mvp.bean.News;
import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;
import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;

/**
 * Created by pwcong on 2016/8/20.
 */
public interface BaseView<T> {

    void setData(List<T> data);

    interface MainActivityView{
        void startCityPickerActivityForResult();
        void switchNews();
        void switchWeather(String cityname);
        void switchJoke();
        void switchAbout();
        void switchSetting();
    }

    interface NewsDetailActivityView {
        void loadData();
        void shareData();
        void showError();
        void showProgress();
        void hideProgress();
    }

    interface NewsTabFragmentView extends BaseView<NewsTab>{
        void showError();
    }

    interface NewsFragmentView extends BaseView<News>{
        void toDetailActivity(News news);
        void showError(String errors);
        void showProgress();
        void hideProgress();
    }

    interface WeatherFragmentView {
        void showProgress();
        void hideProgress();
        void setData(WeatherBean.Data data);
        void showError(String error);
    }

    interface JokeFragmentView extends BaseView<Joke>{
        void showHeadProgress();
        void hideHeadProgress();
        void loadMore(List<Joke> more);
        void showError();
    }






}
