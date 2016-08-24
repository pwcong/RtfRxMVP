package me.pwcong.rtfrxmvp.mvp.presenter;

import me.pwcong.rtfrxmvp.mvp.bean.NewsBean;
import me.pwcong.rtfrxmvp.mvp.model.BaseModel;
import me.pwcong.rtfrxmvp.mvp.model.NewsFragmentModelImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import rx.Subscriber;

/**
 * Created by pwcong on 2016/8/21.
 */
public class NewsFragmentPresenterImpl extends BasePresenter<BaseView.NewsFragmentView> implements BasePresenter.NewsFragmentPresenter{

    BaseModel.NewsFragmentModel model;

    public NewsFragmentPresenterImpl(BaseView.NewsFragmentView view) {
        super(view);

        model=new NewsFragmentModelImpl();

    }

    @Override
    public void initNewsFragmentData(String type) {

        model.getData(type, new Subscriber<NewsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showError();
            }

            @Override
            public void onNext(NewsBean newsBean) {
                view.setData(newsBean.getResult().getData());
            }
        });

    }
}
