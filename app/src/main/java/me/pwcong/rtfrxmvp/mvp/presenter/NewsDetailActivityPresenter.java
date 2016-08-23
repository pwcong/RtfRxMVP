package me.pwcong.rtfrxmvp.mvp.presenter;

import java.util.List;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/23.
 */
public class NewsDetailActivityPresenter extends BasePresenter<BaseView.NewsDetailActivityView,Void> {


    public NewsDetailActivityPresenter(BaseView.NewsDetailActivityView view) {
        super(view);
    }

    public void onMenuItemInteraction(int id){

        switch (id){
            case R.id.item_share:

                view.shareData();

                break;
            default:break;
        }

    }

    public void loadData(){
        view.showProgress();
        view.loadData();
    }

    @SuppressWarnings("useless method")
    @Override
    public void setData(List<Void> data) {
    }
}
