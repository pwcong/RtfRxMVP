package me.pwcong.rtfrxmvp.mvp.presenter;

import java.util.List;

/**
 * Created by pwcong on 2016/8/20.
 */
public abstract class BasePresenter<T,R> {

    public final T view;

    public BasePresenter(T view) {
        this.view = view;
    }

    public abstract void setData(List<R> data);
}
