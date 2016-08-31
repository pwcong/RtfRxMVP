package me.pwcong.rtfrxmvp.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.Life;
import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import me.pwcong.rtfrxmvp.utils.ResourceUtils;
import me.pwcong.rtfrxmvp.widget.RecyclerViewDivider;

/**
 * Created by pwcong on 2016/8/28.
 */
public class WeatherFragmentRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    Context context;
    WeatherBean.Data data;

    public WeatherFragmentRecyclerAdapter(Context context, WeatherBean.Data data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case Constants.TAG_HEADER:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_weather_header, parent, false);
                return new WeatherHeaderItemViewHolder(view1);
            case Constants.TAG_DIVIDER_1:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_divider, parent, false);
                return new TextDividerViewHolder(view2);
            case Constants.TAG_RECYCLER_VERTICAL:
                View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_vertical, parent, false);
                return new RecyclerItemViewHolder(view3);
            case Constants.TAG_DIVIDER_2:
                View view4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text_divider, parent, false);
                return new TextDividerViewHolder(view4);
            case Constants.TAG_RECYCLER_HORIZONTAL:
                View view5 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_horizontal, parent, false);
                return new RecyclerItemViewHolder(view5);
            default:break;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case Constants.TAG_HEADER:

                ((WeatherHeaderItemViewHolder)holder).bindData(context,data);
                break;

            case Constants.TAG_DIVIDER_1:

                ((TextDividerViewHolder)holder).bindData(ResourceUtils.fromStringResId(R.string.future_5_days));
                break;

            case Constants.TAG_RECYCLER_VERTICAL:

                LinearLayoutManager verticalLayoutManager=new LinearLayoutManager(context);
                verticalLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                ((RecyclerItemViewHolder)holder).bindData(verticalLayoutManager,new WeatherItemRecyclerAdapter(context,data.getWeather()),new RecyclerViewDivider(context,RecyclerViewDivider.VERTICAL_LIST));

                break;

            case Constants.TAG_DIVIDER_2:

                ((TextDividerViewHolder)holder).bindData(ResourceUtils.fromStringResId(R.string.life_stat));
                break;

            case Constants.TAG_RECYCLER_HORIZONTAL:

                LinearLayoutManager horizontalLayoutManager=new LinearLayoutManager(context);

                horizontalLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

                ((RecyclerItemViewHolder)holder).bindData(horizontalLayoutManager,new LifeItemRecyclerAdapter(context,getLifeInfoList(data.getLife().getInfo())),new RecyclerViewDivider(context,RecyclerViewDivider.HORIZONTAL_LIST));


            default:break;
        }


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {

        switch (position){
            case 0:return Constants.TAG_HEADER;
            case 1:return Constants.TAG_DIVIDER_1;
            case 2:return Constants.TAG_RECYCLER_VERTICAL;
            case 3:return Constants.TAG_DIVIDER_2;
            case 4:return Constants.TAG_RECYCLER_HORIZONTAL;
        }

        return -1;
    }

    public class WeatherHeaderItemViewHolder extends RecyclerView.ViewHolder{

        public final View view;
        public final ImageView iv_header;
        public final TextView tv_temperature;
        public final TextView tv_city_name;
        public final TextView tv_weather_info;
        public final TextView tv_wind_direct;
        public final TextView tv_wind_power;
        public final TextView tv_humidity;
        public final TextView tv_pm25;
        public final ImageView iv_weather;

        public WeatherHeaderItemViewHolder(View itemView) {
            super(itemView);

            view=itemView;
            iv_header= (ImageView) itemView.findViewById(R.id.iv_header);
            tv_temperature= (TextView) itemView.findViewById(R.id.tv_temperature);
            tv_city_name= (TextView) itemView.findViewById(R.id.tv_city_name);
            tv_weather_info= (TextView) itemView.findViewById(R.id.tv_weather_info);
            tv_wind_direct= (TextView) itemView.findViewById(R.id.tv_wind_direct);
            tv_wind_power= (TextView) itemView.findViewById(R.id.tv_wind_power);
            tv_humidity= (TextView) itemView.findViewById(R.id.tv_humidity);
            tv_pm25= (TextView) itemView.findViewById(R.id.tv_pm25);
            iv_weather= (ImageView) itemView.findViewById(R.id.iv_weather);
        }

        public void bindData(Context context,WeatherBean.Data data){

            int weatherIconId=Integer.valueOf(data.getRealtime().getWeather().getImg());

            if(data.getRealtime().getWeather().getInfo().contains("晴")){
                Glide.with(context)
                        .load(R.drawable.dialog_bg_sunny)
                        .centerCrop()
                        .into(iv_header);
            }
            else if(data.getRealtime().getWeather().getInfo().contains("雨")){
                Glide.with(context)
                        .load(R.drawable.dialog_bg_rainy)
                        .centerCrop()
                        .into(iv_header);
            }else {
                Glide.with(context)
                        .load(R.drawable.dialog_bg_cloudy)
                        .centerCrop()
                        .into(iv_header);
            }

            if( weatherIconId > -1 && weatherIconId < 32 ){
                Glide.with(context)
                        .load(Constants.WEATHER_ICONS[weatherIconId])
                        .override((int) ResourceUtils.fromDimenResId(R.dimen.size_weather_img),(int)ResourceUtils.fromDimenResId(R.dimen.size_weather_img))
                        .into(iv_weather);
            }
            else {
                Glide.with(context)
                        .load(Constants.WEATHER_ICONS[32])
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

        }

    }

    public class TextDividerViewHolder extends RecyclerView.ViewHolder{

        public final View view;
        public final TextView tv_divider;
        public String string;

        public TextDividerViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            tv_divider= (TextView) itemView.findViewById(R.id.tv_divider);
        }

        public void bindData(String s){
            tv_divider.setText(s);
        }
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder{

        public final View view;
        public final RecyclerView recyclerView;

        public RecyclerItemViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            recyclerView= (RecyclerView) itemView.findViewById(R.id.recycler_view);

        }

        public void bindData(LinearLayoutManager layoutManager, RecyclerView.Adapter adapter, RecyclerViewDivider divider){

            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            recyclerView.addItemDecoration(divider);
        }

    }

    private List<String[]> getLifeInfoList(Life.LifeInfo lifeInfo){

        List<String[]> list=new ArrayList<String[]>();
        list.add(lifeInfo.getChuanyi());
        list.add(lifeInfo.getGanmao());
        list.add(lifeInfo.getKongtiao());
        list.add(lifeInfo.getWuran());
        list.add(lifeInfo.getXiche());
        list.add(lifeInfo.getZiwaixian());

        return list;
    }

}
