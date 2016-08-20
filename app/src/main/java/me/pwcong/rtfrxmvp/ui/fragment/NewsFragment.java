package me.pwcong.rtfrxmvp.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.List;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.FragmentWithTitlePagerAdapter;
import me.pwcong.rtfrxmvp.mvp.bean.FragmentWithTitle;
import me.pwcong.rtfrxmvp.mvp.presenter.NewsFragmentTabPresenter;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsFragment extends BaseFragment implements BaseView.NewsFragmentTabView{

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    NewsFragmentTabPresenter newsFragmentTabPresenter;

    @Override
    protected void initVariable() {

        tabLayout.setupWithViewPager(viewPager);

        newsFragmentTabPresenter=new NewsFragmentTabPresenter(this);

    }

    @Override
    protected void doAction() {

        newsFragmentTabPresenter.initNewsFragmentTab();

    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_news;
    }

    @Override
    public void setData(List<FragmentWithTitle> data) {
        viewPager.setAdapter(new FragmentWithTitlePagerAdapter(getChildFragmentManager(),data));
    }

    @Override
    public void showError() {

    }
}
