package me.pwcong.rtfrxmvp.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding.support.v4.widget.RxSwipeRefreshLayout;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.WeatherFragmentRecyclerAdapter;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import me.pwcong.rtfrxmvp.mvp.presenter.WeatherFragmentPresenterImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import me.pwcong.rtfrxmvp.utils.ResourceUtils;
import me.pwcong.rtfrxmvp.widget.RecyclerViewDivider;
import rx.functions.Action1;

/**
 * Created by pwcong on 2016/8/21.
 */
public class WeatherFragment extends BaseFragment implements BaseView.WeatherFragmentView{

    private final String TAG=getClass().getSimpleName();

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_temperature)
    TextView tv_temperature;
    @BindView(R.id.tv_city_name)
    TextView tv_city_name;
    @BindView(R.id.tv_weather_info)
    TextView tv_weather_info;
    @BindView(R.id.tv_wind_direct)
    TextView tv_wind_direct;
    @BindView(R.id.tv_wind_power)
    TextView tv_wind_power;
    @BindView(R.id.tv_humidity)
    TextView tv_humidity;
    @BindView(R.id.tv_pm25)
    TextView tv_pm25;
    @BindView(R.id.iv_weather)
    ImageView iv_weather;

    WeatherFragmentPresenterImpl presenter;
    String cityname;

    public static WeatherFragment getInstance(String cityname){


        Bundle bundle=new Bundle();
        bundle.putString(Constants.CITY_NAME,cityname);

        WeatherFragment weatherFragment=new WeatherFragment();
        weatherFragment.setArguments(bundle);

        return weatherFragment;
    }


    @Override
    protected void initVariable() {

        presenter=new WeatherFragmentPresenterImpl(this);

        cityname=getArguments().getString(Constants.CITY_NAME);

        initRefreshLayout();
        initRecyclerView();

        Log.i(TAG, "initVariable: OK");

    }

    private void initRecyclerView(){

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new RecyclerViewDivider(getContext(),RecyclerViewDivider.VERTICAL_LIST));


    }

    private void initRefreshLayout(){

        refreshLayout.setColorSchemeResources(R.color.colorPrimaryDark);

        RxSwipeRefreshLayout.refreshes(refreshLayout).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                presenter.initWeatherFragmentData(cityname);
                refreshLayout.setRefreshing(false);
            }
        });

    }


    @Override
    protected void doAction() {
        presenter.initWeatherFragmentData(cityname);
        Log.i(TAG, "doAction: OK");
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void setData(WeatherBean.Data data) {

        int weatherIconId=Integer.valueOf(data.getRealtime().getWeather().getImg());

        if( weatherIconId > -1 && weatherIconId < 32 ){
            Glide.with(getContext())
                    .load(Constants.WEATHERICONS[weatherIconId])
                    .override((int) ResourceUtils.fromDimenResId(R.dimen.size_weather_img),(int)ResourceUtils.fromDimenResId(R.dimen.size_weather_img))
                    .into(iv_weather);
        }
        else {
            Glide.with(getContext())
                    .load(Constants.WEATHERICONS[32])
                    .override((int) ResourceUtils.fromDimenResId(R.dimen.size_weather_img),(int)ResourceUtils.fromDimenResId(R.dimen.size_weather_img))
                    .into(iv_weather);
        }

        tv_temperature.setText(data.getRealtime().getWeather().getTemperature());
        tv_city_name.setText(data.getRealtime().getCity_name());
        tv_weather_info.setText(data.getRealtime().getWeather().getInfo());
        tv_wind_direct.setText(data.getRealtime().getWind().getDirect());
        tv_wind_power.setText(data.getRealtime().getWind().getPower());
        tv_humidity.setText(data.getRealtime().getWeather().getHumidity());
        tv_pm25.setText(data.getPm25().getPm25().getPm25());

        recyclerView.setAdapter(new WeatherFragmentRecyclerAdapter(getContext(),data.getWeather()));
        recyclerView.refreshDrawableState();

        Log.i(TAG, "setData: OK");

    }

    @Override
    public void showError() {

    }
}
