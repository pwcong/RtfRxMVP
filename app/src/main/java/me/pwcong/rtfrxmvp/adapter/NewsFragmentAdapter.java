package me.pwcong.rtfrxmvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding.view.RxView;

import java.util.List;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.mvp.bean.News;
import me.pwcong.rtfrxmvp.utils.ResourceUtils;
import rx.functions.Action1;

/**
 * Created by pwcong on 2016/8/22.
 */
public class NewsFragmentAdapter extends RecyclerView.Adapter<NewsFragmentAdapter.ViewHolder>{

    Context context;
    List<News> newsList;
    NewsItemListener newsItemListener;

    public NewsFragmentAdapter(Context context, List<News> newsList, NewsItemListener newsItemListener) {
        this.context = context;
        this.newsList = newsList;
        this.newsItemListener = newsItemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        News news=newsList.get(position);

        holder.news=news;
        holder.tv_title.setText(news.getTitle());
        holder.tv_author_name.setText(news.getAuthor_name());
        holder.tv_date.setText(news.getDate());
        Glide.with(context)
                .load(news.getThumbnail_pic_s())
                .override((int)ResourceUtils.fromDimenResId(R.dimen.size_item_news_img),(int)ResourceUtils.fromDimenResId(R.dimen.size_item_news_img))
                .into(holder.iv_img);

        if(newsItemListener!=null){
            RxView.clicks(holder.view).subscribe(new Action1<Void>() {
                @Override
                public void call(Void aVoid) {
                    newsItemListener.onNewsItemInteraction(holder.news);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public final View view;
        public final TextView tv_title;
        public final TextView tv_date;
        public final TextView tv_author_name;
        public final ImageView iv_img;

        public News news;

        public ViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            tv_title= (TextView) itemView.findViewById(R.id.tv_title);
            tv_date= (TextView) itemView.findViewById(R.id.tv_date);
            tv_author_name= (TextView) itemView.findViewById(R.id.tv_author_name);
            iv_img= (ImageView) itemView.findViewById(R.id.iv_img);

        }
    }

    public interface NewsItemListener{
        void onNewsItemInteraction(News news);
    }

}
