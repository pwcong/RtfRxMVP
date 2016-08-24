package me.pwcong.rtfrxmvp.mvp.presenter;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/24.
 */
public class MainActivityPresenterImpl extends BasePresenter<BaseView.MainActivityView> implements BasePresenter.MainActivityPresenter {

    public MainActivityPresenterImpl(BaseView.MainActivityView view) {
        super(view);
    }

    @Override
    public void initContent() {
        view.switchNews();
    }

    @Override
    public void onNavigationItemInteraction(int id) {

        switch (id){
            case R.id.item_newspaper:
                view.switchNews();
                break;
            case R.id.item_weather:
                view.switchWeather();
                break;
            default:break;

        }

    }
}
