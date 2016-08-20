package me.pwcong.rtfrxmvp.mvp.presenter;

/**
 * Created by pwcong on 2016/8/20.
 */
public abstract class BasePresenter<T> {

    public T view;

    public BasePresenter(T view) {
        this.view = view;
    }
}
