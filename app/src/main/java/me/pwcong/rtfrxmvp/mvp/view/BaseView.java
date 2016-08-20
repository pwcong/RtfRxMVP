package me.pwcong.rtfrxmvp.mvp.view;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.FragmentWithTitle;

/**
 * Created by pwcong on 2016/8/20.
 */
public interface BaseView<T> {

    void setData(List<T> data);

    interface NewsFragmentTabView extends BaseView<FragmentWithTitle>{
        void showError();
    }





}
