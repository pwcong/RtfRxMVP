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

/**
 * Created by pwcong on 2016/8/29.
 */
public class LifeItemRecyclerAdapter extends RecyclerView.Adapter<LifeItemRecyclerAdapter.ViewHolder> {

    Context context;
    List<String[]> stringsList;

    public LifeItemRecyclerAdapter(Context context, List<String[]> stringsList) {
        this.context = context;
        this.stringsList = stringsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_life, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.lifeInfo = stringsList.get(position);

        Glide.with(context).load(Constants.LIFEINFO_ICONS[position])
                .into(holder.iv_life);

        holder.tv_type.setText(Constants.LIFEINFO_TYPE[position]);
        holder.tv_level.setText(holder.lifeInfo[0]);
        holder.tv_detail.setText(holder.lifeInfo[1]);

    }

    @Override
    public int getItemCount() {
        return stringsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public String[] lifeInfo;
        public final View view;
        public final ImageView iv_life;
        public final TextView tv_type;
        public final TextView tv_level;
        public final TextView tv_detail;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            iv_life = (ImageView) itemView.findViewById(R.id.iv_life);
            tv_type = (TextView) itemView.findViewById(R.id.tv_type);
            tv_level = (TextView) itemView.findViewById(R.id.tv_level);
            tv_detail = (TextView) itemView.findViewById(R.id.tv_detail);

        }
    }

}
