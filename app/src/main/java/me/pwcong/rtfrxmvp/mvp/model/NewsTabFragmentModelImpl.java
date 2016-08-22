package me.pwcong.rtfrxmvp.mvp.model;

import java.util.ArrayList;
import java.util.List;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;
import me.pwcong.rtfrxmvp.mvp.presenter.BasePresenter;
import me.pwcong.rtfrxmvp.mvp.presenter.NewsFragmentPresenter;
import me.pwcong.rtfrxmvp.mvp.presenter.NewsTabFragmentPresenter;
import me.pwcong.rtfrxmvp.ui.fragment.NewsFragment;
import me.pwcong.rtfrxmvp.utils.StringUtils;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsTabFragmentModelImpl implements BaseModel.NewsFragmentTabModel {

    @Override
    public void setData(NewsTabFragmentPresenter presenter) {

        List<NewsTab> newsTabList=new ArrayList<>();
        newsTabList.add(new NewsTab("top", StringUtils.fromStringResId(R.string.top)));
        newsTabList.add(new NewsTab("shehui", StringUtils.fromStringResId(R.string.shehui)));
        newsTabList.add(new NewsTab("guonei", StringUtils.fromStringResId(R.string.guonei)));
        newsTabList.add(new NewsTab("guoji", StringUtils.fromStringResId(R.string.guoji)));
        newsTabList.add(new NewsTab("yule", StringUtils.fromStringResId(R.string.yule)));
        newsTabList.add(new NewsTab("tiyu", StringUtils.fromStringResId(R.string.tiyu)));
        newsTabList.add(new NewsTab("junshi", StringUtils.fromStringResId(R.string.junshi)));
        newsTabList.add(new NewsTab("keji", StringUtils.fromStringResId(R.string.keji)));
        newsTabList.add(new NewsTab("caijing", StringUtils.fromStringResId(R.string.caijing)));
        newsTabList.add(new NewsTab("shishang", StringUtils.fromStringResId(R.string.shishang)));
        presenter.setData(newsTabList);


    }
}
