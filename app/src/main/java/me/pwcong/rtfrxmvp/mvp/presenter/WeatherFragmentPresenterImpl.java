package me.pwcong.rtfrxmvp.mvp.presenter;

import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import me.pwcong.rtfrxmvp.mvp.model.BaseModel;
import me.pwcong.rtfrxmvp.mvp.model.WeatherFragmentModelImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import rx.Subscriber;

/**
 * Created by pwcong on 2016/8/28.
 */
public class WeatherFragmentPresenterImpl extends BasePresenter<BaseView.WeatherFragmentView> implements BasePresenter.WeatherFragmentPresenter {


    BaseModel.WeatherFragmentModel model;

    public WeatherFragmentPresenterImpl(BaseView.WeatherFragmentView view) {
        super(view);
        model=new WeatherFragmentModelImpl();
    }


    @Override
    public void initData(String cityname) {

        model.getData(cityname, new Subscriber<WeatherBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showError();
            }

            @Override
            public void onNext(WeatherBean weatherBean) {
                view.setData(weatherBean.getResult().getData());
            }
        });

    }
}
