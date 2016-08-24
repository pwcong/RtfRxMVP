package me.pwcong.rtfrxmvp.mvp.view;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.News;
import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;

/**
 * Created by pwcong on 2016/8/20.
 */
public interface BaseView<T> {

    void setData(List<T> data);

    interface MainActivityView{
        void switchNews();
        void switchWeather();
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
        void showError();
    }






}
