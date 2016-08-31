package me.pwcong.rtfrxmvp.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jakewharton.rxbinding.support.v4.widget.RxSwipeRefreshLayout;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.WeatherFragmentRecyclerAdapter;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import me.pwcong.rtfrxmvp.mvp.presenter.BasePresenter;
import me.pwcong.rtfrxmvp.mvp.presenter.WeatherFragmentPresenterImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
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

    BasePresenter.WeatherFragmentPresenter presenter;
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

        LinearLayoutManager verticalLayoutManager=new LinearLayoutManager(getContext());
        verticalLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(verticalLayoutManager);
        recyclerView.addItemDecoration(new RecyclerViewDivider(getContext(),RecyclerViewDivider.VERTICAL_LIST));


    }

    private void initRefreshLayout(){

        refreshLayout.setColorSchemeResources(R.color.colorPrimaryDark);

        RxSwipeRefreshLayout.refreshes(refreshLayout).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                presenter.initData(cityname);
            }
        });

    }


    @Override
    protected void doAction() {
        presenter.initData(cityname);
        Log.i(TAG, "doAction: OK");
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void showProgress() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgress() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void setData(WeatherBean.Data data) {


        recyclerView.setAdapter(new WeatherFragmentRecyclerAdapter(getContext(),data));
        recyclerView.refreshDrawableState();

        Log.i(TAG, "setData: OK");

    }

    @Override
    public void showError(String error) {
        showSnackBar(view,error);
    }
}
