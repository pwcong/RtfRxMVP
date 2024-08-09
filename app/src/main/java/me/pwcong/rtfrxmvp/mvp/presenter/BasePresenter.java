package me.pwcong.rtfrxmvp.mvp.presenter;

import me.pwcong.rtfrxmvp.rxbus.event.MainActivityEvent;

/**
 * Created by pwcong on 2016/8/20.
 */
public abstract class BasePresenter<T> {

    public final T view;

    public BasePresenter(T view) {
        this.view = view;
    }

    public interface NewsTabFragmentPresenter {
        void initNewsFragmentTab();
    }

    public interface NewsFragmentPresenter {
        void initNewsFragmentData(String type);
    }

    public interface NewsDetailActivityPresenter {
        void loadData();

        void onMenuItemInteraction(int id);
    }

    public interface MainActivityPresenter {
        void initContent();

        void onBusEventInteraction(MainActivityEvent event);

        void onNavigationItemInteraction(int id);

        void onMenuItemIntrraction(int id);

    }

    public interface WeatherFragmentPresenter {
        void initData(String cityname);
    }

    public interface JokeFragmentPresenter {

        void initData(int page);

        void loadMore(int page);

    }

}
