package me.pwcong.rtfrxmvp.mvp.model;

import me.pwcong.rtfrxmvp.mvp.presenter.NewsFragmentPresenter;
import me.pwcong.rtfrxmvp.mvp.presenter.NewsTabFragmentPresenter;

/**
 * Created by pwcong on 2016/8/20.
 */
public interface BaseModel<T> {

    void setData(T presenter);

    interface NewsFragmentTabModel extends BaseModel<NewsTabFragmentPresenter>{
    }

    interface NewsFragmentModel extends BaseModel<NewsFragmentPresenter>{
        void setData(NewsFragmentPresenter presenter,String type);
    }


}
