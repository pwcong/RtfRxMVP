package me.pwcong.rtfrxmvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;
import me.pwcong.rtfrxmvp.component.fragment.NewsFragment;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewTabFragmentPagerAdapter extends BasePagerAdapter<NewsTab> {

    public NewTabFragmentPagerAdapter(FragmentManager fm, List<NewsTab> list) {
        super(fm, list);
    }

    @Override
    protected Fragment getFragment(NewsTab newsTab) {
        return NewsFragment.newInstant(newsTab.getType());
    }

    @Override
    protected CharSequence getTitle(NewsTab newsTab) {
        return newsTab.getTitle();
    }
}
