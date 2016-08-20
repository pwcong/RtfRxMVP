package me.pwcong.rtfrxmvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.pwcong.rtfrxmvp.R;

/**
 * Created by pwcong on 2016/8/20.
 */
public class SimpleDataAdapter extends RecyclerView.Adapter<SimpleDataAdapter.ViewHolder>{

    List<String> stringList;

    public SimpleDataAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simpledata,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_simple.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final View view;
        public final TextView tv_simple;
        public String string;

        public ViewHolder(View itemView) {
            super(itemView);

            view=itemView;
            tv_simple= (TextView) itemView.findViewById(R.id.tv_simple);

        }
    }

    public static List<String> getSimpleData(){

        List<String> stringList=new ArrayList<>();
        for(int i=0;i<50;i++){
            stringList.add("Hello World "+i);
        }
        return stringList;

    }

}
