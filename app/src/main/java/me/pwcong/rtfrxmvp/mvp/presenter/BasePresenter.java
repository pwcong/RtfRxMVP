package me.pwcong.rtfrxmvp.mvp.presenter;

/**
 * Created by pwcong on 2016/8/20.
 */
public abstract class BasePresenter<T> {

    public final T view;

    public BasePresenter(T view) {
        this.view = view;
    }


    interface NewsTabFragmentPresenter{
        void initNewsFragmentTab();
    }

    interface NewsFragmentPresenter{
        void initNewsFragmentData(String type);
    }

    interface NewsDetailActivityPresenter{
        void loadData();
        void onMenuItemInteraction(int id);
    }

    interface MainActivityPresenter{
        void initContent();
        void onNavigationItemInteraction(int id);
        void onMenuItemIntrraction(int id);

    }

    interface WeatherGragmentPresenter{
        void initWeatherFragmentData(String cityname);

    }

}
