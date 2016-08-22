package me.pwcong.rtfrxmvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.NewsFragmentAdapter;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.News;
import me.pwcong.rtfrxmvp.mvp.presenter.NewsFragmentPresenter;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsFragment extends BaseFragment implements BaseView.NewsFragmentView{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    String type;
    NewsFragmentPresenter presenter;

    public static NewsFragment newInstant(String type){

        Bundle bundle=new Bundle();
        bundle.putString(Constants.TOUTIAO_TYPE,type);

        NewsFragment newsFragment=new NewsFragment();
        newsFragment.setArguments(bundle);

        return newsFragment;
    }



    @Override
    protected void initVariable() {

        type=getArguments().getString(Constants.TOUTIAO_TYPE);
        presenter=new NewsFragmentPresenter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    protected void doAction() {
        presenter.initNewsFragmentData(type);
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_simpledata;
    }


    @Override
    public void showError() {

    }

    @Override
    public void setData(List<News> data) {
        recyclerView.setAdapter(new NewsFragmentAdapter(data));
    }
}
