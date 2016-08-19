package me.pwcong.rtfrxmvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.pwcong.rtfrxmvp.R;

/**
 * Created by pwcong on 2016/8/19.
 */
public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHodler>{

    List<String> stringList;

    public SimpleAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple, parent, false);

        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {

        holder.tv_simple.setText(stringList.get(position));

    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{

        public final View view;
        public final TextView tv_simple;


        public ViewHodler(View itemView) {
            super(itemView);
            view=itemView;
            tv_simple= (TextView) itemView.findViewById(R.id.tv_simple);

        }
    }

}
