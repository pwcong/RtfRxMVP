package me.pwcong.rtfrxmvp.mvp.model;

import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.JokeBean;
import me.pwcong.rtfrxmvp.network.Api;
import me.pwcong.rtfrxmvp.network.JokeService;
import me.pwcong.rtfrxmvp.utils.TimeUtils;
import rx.Subscriber;

/**
 * Created by pwcong on 2016/8/30.
 */
public class JokeFragmentModelImpl implements BaseModel.JokeFragmentModel {

    JokeService service;

    public JokeFragmentModelImpl() {
        super();
        service=new JokeService();
    }

    @Override
    public void getData(int page, Subscriber<JokeBean> subscriber) {

        service.getJoke(Constants.DESC,page,Constants.PAGESIZE, TimeUtils.getCurTimeMillsLimit10(), Api.KEY_JOKE,subscriber);

    }
}
