package me.pwcong.rtfrxmvp.mvp.presenter;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.manager.SharedPreferencesManager;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import me.pwcong.rtfrxmvp.utils.StringUtils;

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

                String cityname = SharedPreferencesManager.getInstance().getString(Constants.CITY_NAME, null);

                if(StringUtils.isEmpty(cityname)){
                    view.startCityPickerActivityForResult();
                }else {
                    view.switchWeather(cityname);
                }

                break;
            case R.id.item_joke:
                view.switchJoke();
                break;

            case R.id.item_about:
                view.switchAbout();
                break;

            case R.id.item_setting:
                view.switchSetting();
                break;

            default:break;

        }

    }

    @Override
    public void onMenuItemIntrraction(int id) {
        switch (id){

            case R.id.item_location:

                view.startCityPickerActivityForResult();

                break;
            default:break;

        }
    }
}
