package me.pwcong.rtfrxmvp.mvp.presenter;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;
import me.pwcong.rtfrxmvp.mvp.model.BaseModel;
import me.pwcong.rtfrxmvp.mvp.model.NewsTabFragmentModelImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsTabFragmentPresenter extends BasePresenter<BaseView.NewsTabFragmentView,NewsTab>{

    BaseModel.NewsFragmentTabModel model;

    public NewsTabFragmentPresenter(BaseView.NewsTabFragmentView view) {
        super(view);
        model=new NewsTabFragmentModelImpl();
    }

    @Override
    public void setData(List<NewsTab> data) {
        view.setData(data);
    }


    public void initNewsFragmentTab(){
        model.setData(this);
    }



}
