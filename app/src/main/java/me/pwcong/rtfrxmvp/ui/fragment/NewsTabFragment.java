package me.pwcong.rtfrxmvp.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import java.util.List;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.NewTabFragmentPagerAdapter;
import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;
import me.pwcong.rtfrxmvp.mvp.presenter.BasePresenter;
import me.pwcong.rtfrxmvp.mvp.presenter.NewsTabFragmentPresenterImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsTabFragment extends BaseFragment implements BaseView.NewsTabFragmentView {

    private final String TAG=getClass().getSimpleName();

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    BasePresenter.NewsTabFragmentPresenter presenter;

    @Override
    protected void initVariable() {

        tabLayout.setupWithViewPager(viewPager);

        presenter=new NewsTabFragmentPresenterImpl(this);
        Log.i(TAG, "initVariable: OK");

    }

    @Override
    protected void doAction() {

        presenter.initNewsFragmentTab();
        Log.i(TAG, "doAction: OK");

    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_newstab;
    }


    @Override
    public void showError() {

    }

    @Override
    public void setData(List<NewsTab> data) {

        viewPager.setAdapter(new NewTabFragmentPagerAdapter(getChildFragmentManager(),data));
        Log.i(TAG, "setData: OK");

    }
}
