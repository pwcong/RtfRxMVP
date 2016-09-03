package me.pwcong.rtfrxmvp.component.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.jakewharton.rxbinding.support.v4.widget.RxSwipeRefreshLayout;

import java.util.List;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.JokeItemAdapter;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.Joke;
import me.pwcong.rtfrxmvp.mvp.presenter.BasePresenter;
import me.pwcong.rtfrxmvp.mvp.presenter.JokeFragmentPresenterImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import me.pwcong.rtfrxmvp.utils.ActivityUtils;
import rx.functions.Action1;

/**
 * Created by pwcong on 2016/8/30.
 */
public class JokeFragment extends BaseFragment implements BaseView.JokeFragmentView{

    private final String TAG=getClass().getSimpleName();


    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    View progress_view;

    int page=1;

    BasePresenter.JokeFragmentPresenter presenter;

    JokeItemAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        progress_view= LayoutInflater.from(getContext()).inflate(R.layout.view_progress, container,false);

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    protected void initVariable() {

        presenter=new JokeFragmentPresenterImpl(this);

        initRycyclerView();
        initRefreshLayout();

        Log.i(TAG, "initVariable: OK");
    }

    private void initRycyclerView(){

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private void initRefreshLayout(){

        refreshLayout.setColorSchemeResources(R.color.colorAccent);

        RxSwipeRefreshLayout.refreshes(refreshLayout).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                page=1;
                presenter.initData(page);
            }
        });

    }

    @Override
    protected void doAction() {
        presenter.initData(page);
        Log.i(TAG, "doAction: OK");
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_joke;
    }

    @Override
    public void setData(List<Joke> data) {

        adapter=new JokeItemAdapter(data);
        adapter.setLoadingView(progress_view);
        adapter.openLoadMore(Constants.PAGESIZE);

        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page++;
                presenter.loadMore(page);
            }
        });

        recyclerView.addOnItemTouchListener(new OnItemLongClickListener() {
            @Override
            public void SimpleOnItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

                ActivityUtils.share(((Joke)(baseQuickAdapter.getData().get(i))).getContent());

            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.refreshDrawableState();

        Log.i(TAG, "setData: OK");
        
    }

    @Override
    public void showHeadProgress() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideHeadProgress() {
        refreshLayout.setRefreshing(false);
    }


    @Override
    public void loadMore(List<Joke> more) {

        adapter.addData(more);
        Log.i(TAG, "loadMore: OK");

    }

    @Override
    public void showError() {
        showSnackBar(view,"获取失败！");
    }
}
