package me.pwcong.rtfrxmvp.mvp.bean;

import android.support.v4.app.Fragment;

/**
 * Created by pwcong on 2016/8/20.
 */
public class FragmentWithTitle{

    Fragment fragment;
    String title;

    public FragmentWithTitle(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "FragmentWithTitle{" +
                "fragment=" + fragment +
                ", title='" + title + '\'' +
                '}';
    }
}
