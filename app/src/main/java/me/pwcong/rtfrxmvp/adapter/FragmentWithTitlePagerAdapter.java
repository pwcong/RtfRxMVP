package me.pwcong.rtfrxmvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.FragmentWithTitle;

/**
 * Created by pwcong on 2016/8/20.
 */
public class FragmentWithTitlePagerAdapter extends BasePagerAdapter<FragmentWithTitle> {

    public FragmentWithTitlePagerAdapter(FragmentManager fm, List<FragmentWithTitle> list) {
        super(fm, list);
    }

    @Override
    protected Fragment getFragment(FragmentWithTitle fragmentWithTitle) {
        return fragmentWithTitle.getFragment();
    }

    @Override
    protected CharSequence getTitle(FragmentWithTitle fragmentWithTitle) {
        return fragmentWithTitle.getTitle();
    }
}
