package me.pwcong.rtfrxmvp.mvp.presenter;

import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;
import me.pwcong.rtfrxmvp.mvp.model.BaseModel;
import me.pwcong.rtfrxmvp.mvp.model.NewsTabFragmentModelImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import me.pwcong.rtfrxmvp.utils.ListUtils;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsTabFragmentPresenterImpl extends BasePresenter<BaseView.NewsTabFragmentView>
        implements BasePresenter.NewsTabFragmentPresenter {

    BaseModel.NewsFragmentTabModel model;

    public NewsTabFragmentPresenterImpl(BaseView.NewsTabFragmentView view) {
        super(view);
        model = new NewsTabFragmentModelImpl();
    }

    @Override
    public void initNewsFragmentTab() {
        List<NewsTab> newsTabList = model.getData();
        if (!ListUtils.isNullOrEmpty(newsTabList)) {
            view.setData(newsTabList);
        } else {
            view.showError();
        }
    }
}
