package me.pwcong.rtfrxmvp.mvp.presenter;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.FragmentWithTitle;
import me.pwcong.rtfrxmvp.mvp.model.BaseDataBridge;
import me.pwcong.rtfrxmvp.mvp.model.BaseModel;
import me.pwcong.rtfrxmvp.mvp.model.NewsFragmentTabModelImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsFragmentTabPresenter extends BasePresenter<BaseView.NewsFragmentTabView> implements BaseDataBridge<FragmentWithTitle>{

    BaseModel.NewsFragmentTabModel newsFragmentTabModel;

    public NewsFragmentTabPresenter(BaseView.NewsFragmentTabView view) {
        super(view);
        newsFragmentTabModel=new NewsFragmentTabModelImpl();
    }

    public void initNewsFragmentTab(){
        newsFragmentTabModel.setData(this);
    }

    @Override
    public void setData(List<FragmentWithTitle> data) {
        view.setData(data);
    }

    @Override
    public void onError() {

    }
}
