package me.pwcong.rtfrxmvp.mvp.model;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.FragmentWithTitle;

/**
 * Created by pwcong on 2016/8/20.
 */
public interface BaseModel<T> {

    void setData(T dataBridge);

    public interface NewsFragmentTabModel extends BaseModel<BaseDataBridge<FragmentWithTitle>>{
    }


}
