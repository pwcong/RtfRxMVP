package me.pwcong.rtfrxmvp.mvp.model;

import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import me.pwcong.rtfrxmvp.network.Api;
import me.pwcong.rtfrxmvp.network.WeatherApi;
import me.pwcong.rtfrxmvp.network.WeatherService;
import rx.Subscriber;

/**
 * Created by pwcong on 2016/8/28.
 */
public class WeatherFragmentModelImpl implements BaseModel.WeatherFragmentModel {

    WeatherService service;

    public WeatherFragmentModelImpl() {
        super();
        service = new WeatherService();
    }

    @Override
    public void getData(String cityname, Subscriber<WeatherBean> subscriber) {
        service.getWeather(cityname, Api.KEY_WEATHER, subscriber);
    }
}
