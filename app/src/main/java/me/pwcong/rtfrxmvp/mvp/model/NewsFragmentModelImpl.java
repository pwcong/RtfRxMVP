package me.pwcong.rtfrxmvp.mvp.model;

import me.pwcong.rtfrxmvp.mvp.bean.NewsBean;
import me.pwcong.rtfrxmvp.network.Api;
import me.pwcong.rtfrxmvp.network.TouTiaoService;
import rx.Subscriber;

/**
 * Created by pwcong on 2016/8/21.
 */
public class NewsFragmentModelImpl implements BaseModel.NewsFragmentModel {

    TouTiaoService service;

    public NewsFragmentModelImpl() {
        super();
        service = new TouTiaoService();

    }

    @Override
    public void getData(String type, Subscriber<NewsBean> subscriber) {

        service.getNews(type, Api.KEY_TOUTIAO, subscriber);

    }
}
