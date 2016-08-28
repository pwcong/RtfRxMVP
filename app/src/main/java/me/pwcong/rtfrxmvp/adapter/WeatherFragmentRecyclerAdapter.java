package me.pwcong.rtfrxmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.Weather;

/**
 * Created by pwcong on 2016/8/28.
 */
public class WeatherFragmentRecyclerAdapter extends RecyclerView.Adapter<WeatherFragmentRecyclerAdapter.ViewHodler> {

    Context context;
    List<Weather> weatherList;

    public WeatherFragmentRecyclerAdapter(Context context, List<Weather> weatherList) {
        this.context = context;
        this.weatherList = weatherList;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {

        holder.weather=weatherList.get(position);

        int weatherIconId=Integer.valueOf(holder.weather.getInfo().getDay()[0]);

        if( weatherIconId > -1 && weatherIconId < 32 ){
            Glide.with(context)
                    .load(Constants.WEATHERICONS[weatherIconId])
            .into(holder.iv_weather);
        }
        else {
            Glide.with(context)
                    .load(Constants.WEATHERICONS[32])
                    .into(holder.iv_weather);
        }

        holder.tv_date.setText(holder.weather.getDate());
        holder.tv_week.setText(holder.weather.getWeek());
        holder.tv_nongli.setText(holder.weather.getNongli());
        holder.tv_weather_info.setText(holder.weather.getInfo().getDay()[1]);
        holder.tv_wind_direct.setText(holder.weather.getInfo().getDay()[3]);
        holder.tv_wind_power.setText(holder.weather.getInfo().getDay()[4]);
        holder.tv_temperature.setText(holder.weather.getInfo().getDay()[2]);


    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{

        public Weather weather;

        public final View view;
        public final ImageView iv_weather;
        public final TextView tv_date;
        public final TextView tv_week;
        public final TextView tv_nongli;
        public final TextView tv_weather_info;
        public final TextView tv_wind_direct;
        public final TextView tv_wind_power;
        public final TextView tv_temperature;


        public ViewHodler(View itemView) {
            super(itemView);

            view=itemView;
            iv_weather= (ImageView) itemView.findViewById(R.id.iv_weather);
            tv_date= (TextView) itemView.findViewById(R.id.tv_date);
            tv_week= (TextView) itemView.findViewById(R.id.tv_week);
            tv_nongli= (TextView) itemView.findViewById(R.id.tv_nongli);
            tv_weather_info= (TextView) itemView.findViewById(R.id.tv_weather_info);
            tv_wind_direct= (TextView) itemView.findViewById(R.id.tv_wind_direct);
            tv_wind_power= (TextView) itemView.findViewById(R.id.tv_wind_power);
            tv_temperature= (TextView) itemView.findViewById(R.id.tv_temperature);


        }
    }

}
