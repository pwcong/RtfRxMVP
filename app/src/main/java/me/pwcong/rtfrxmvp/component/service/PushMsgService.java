package me.pwcong.rtfrxmvp.component.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.manager.SharedPreferencesManager;
import me.pwcong.rtfrxmvp.mvp.bean.Realtime;
import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import me.pwcong.rtfrxmvp.network.Api;
import me.pwcong.rtfrxmvp.network.WeatherService;
import me.pwcong.rtfrxmvp.utils.NotificationUtils;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by pwcong on 2016/9/2.
 */
public class PushMsgService extends Service {

    private final String TAG=getClass().getSimpleName();

    private Subscription subscribe;

    private WeatherService service;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        service=new WeatherService();

        int delay = SharedPreferencesManager.getInstance().getInt(Constants.PUSH_MSG_TIMER, 1);

        subscribe = Observable.timer(delay, delay, TimeUnit.HOURS, Schedulers.newThread()).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                pushWeatherMsg();
            }
        });


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        flags=START_STICKY;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: OK");

        subscribe.unsubscribe();
    }

    private void pushWeatherMsg(){

        service.getWeather(SharedPreferencesManager.getInstance().getString(Constants.CITY_NAME, "深圳"), Api.KEY_WEATHER, new Subscriber<WeatherBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(WeatherBean weatherBean) {

                if(weatherBean.getError_code()==0) {
                    Realtime realtime = weatherBean.getResult().getData().getRealtime();

                    Notification notification = new Notification.Builder(PushMsgService.this)
                            .setSmallIcon(R.mipmap.icon)
                            .setTicker("有新的天气预报！")
                            .setContentTitle(realtime.getCity_name())
                            .setContentText(realtime.getWeather().getInfo() + "，当前温度为 " + realtime.getWeather().getTemperature()
                                    + "° ，湿度为 " + realtime.getWeather().getHumidity() + "%")
                            .getNotification();

                    notification.flags |= Notification.FLAG_AUTO_CANCEL;
                    notification.defaults |= Notification.DEFAULT_SOUND;
                    notification.defaults |= Notification.DEFAULT_VIBRATE;

                    NotificationUtils.notify(TAG,Constants.NOTIFICATION_WEATHER_ID,notification);
                }
            }
        });


    }

}
