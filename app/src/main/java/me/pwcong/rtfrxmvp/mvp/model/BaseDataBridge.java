package me.pwcong.rtfrxmvp.mvp.model;

import java.util.List;

/**
 * Created by pwcong on 2016/8/20.
 */
public interface BaseDataBridge<T> {

    void setData(List<T> data);

    void onError();


}
