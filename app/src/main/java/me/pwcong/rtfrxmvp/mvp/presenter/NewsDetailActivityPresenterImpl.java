package me.pwcong.rtfrxmvp.mvp.presenter;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;

/**
 * Created by pwcong on 2016/8/23.
 */
public class NewsDetailActivityPresenterImpl extends BasePresenter<BaseView.NewsDetailActivityView> implements BasePresenter.NewsDetailActivityPresenter {


    public NewsDetailActivityPresenterImpl(BaseView.NewsDetailActivityView view) {
        super(view);
    }

    @Override
    public void loadData() {
        view.showProgress();
        view.loadData();
    }

    @Override
    public void onMenuItemInteraction(int id) {
        switch (id){
            case R.id.item_share:
                view.shareData();
                break;
            default:break;
        }
    }

}
