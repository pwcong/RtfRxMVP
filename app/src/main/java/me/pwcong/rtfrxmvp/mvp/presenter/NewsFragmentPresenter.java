package me.pwcong.rtfrxmvp.mvp.presenter;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.News;
import me.pwcong.rtfrxmvp.mvp.bean.NewsBean;
import me.pwcong.rtfrxmvp.mvp.model.BaseModel;
import me.pwcong.rtfrxmvp.mvp.model.NewsFragmentModelImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/21.
 */
public class NewsFragmentPresenter extends BasePresenter<BaseView.NewsFragmentView,News> {

    BaseModel.NewsFragmentModel model;

    public NewsFragmentPresenter(BaseView.NewsFragmentView view) {
        super(view);

        model=new NewsFragmentModelImpl();

    }

    @Override
    public void setData(List<News> data) {
        view.setData(data);
    }

    public void initNewsFragmentData(String type){
        model.setData(this,type);
    }

}
