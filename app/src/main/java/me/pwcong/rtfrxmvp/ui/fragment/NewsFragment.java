package me.pwcong.rtfrxmvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jakewharton.rxbinding.support.v4.widget.RxSwipeRefreshLayout;

import java.util.List;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.NewsFragmentAdapter;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.News;
import me.pwcong.rtfrxmvp.mvp.presenter.NewsFragmentPresenterImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import me.pwcong.rtfrxmvp.ui.activity.NewsDetailActivity;
import me.pwcong.rtfrxmvp.widget.RecyclerViewDivider;
import rx.functions.Action1;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsFragment extends BaseFragment implements BaseView.NewsFragmentView {

    private final String TAG=getClass().getSimpleName();

    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    String type;
    NewsFragmentPresenterImpl presenter;

    public static NewsFragment newInstant(String type){

        Bundle bundle=new Bundle();
        bundle.putString(Constants.TYPE,type);

        NewsFragment newsFragment=new NewsFragment();
        newsFragment.setArguments(bundle);

        return newsFragment;
    }

    @Override
    protected void initVariable() {

        presenter=new NewsFragmentPresenterImpl(this);

        type=getArguments().getString(Constants.TYPE);

        initRecyclerView();
        initRefreshLayout();

        Log.i(TAG, "initVariable: OK");

    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new RecyclerViewDivider(getContext(),RecyclerViewDivider.VERTICAL_LIST));

    }


    private void initRefreshLayout(){

        refreshLayout.setColorSchemeResources(R.color.colorPrimaryDark);

        RxSwipeRefreshLayout.refreshes(refreshLayout).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                presenter.initNewsFragmentData(type);
                refreshLayout.setRefreshing(false);
                Log.i(TAG, "call: OK");
            }
        });
    }

    @Override
    protected void doAction() {
        presenter.initNewsFragmentData(type);
        Log.i(TAG, "doAction: OK");
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_news;
    }


    @Override
    public void toDetailActivity(News news) {

        Bundle bundle=new Bundle();
        bundle.putString(Constants.TITLE,news.getTitle());
        bundle.putString(Constants.URL_IMG,news.getThumbnail_pic_s());
        bundle.putString(Constants.URL_CONTENT,news.getUrl());

        Intent intent=new Intent(getActivity(),NewsDetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void showError() {

    }

    @Override
    public void setData(List<News> data) {

        recyclerView.setAdapter(new NewsFragmentAdapter(getContext(),data,this));
        Log.i(TAG, "setData: OK");
    }

}