package me.pwcong.rtfrxmvp.mvp.model;

import java.util.ArrayList;
import java.util.List;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.mvp.bean.NewsTab;
import me.pwcong.rtfrxmvp.utils.ResourceUtils;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsTabFragmentModelImpl implements BaseModel.NewsFragmentTabModel {

    @Override
    public List<NewsTab> getData() {

        List<NewsTab> newsTabList = new ArrayList<>();
        newsTabList.add(new NewsTab("top", ResourceUtils.fromStringResId(R.string.top)));
        newsTabList.add(new NewsTab("shehui", ResourceUtils.fromStringResId(R.string.shehui)));
        newsTabList.add(new NewsTab("guonei", ResourceUtils.fromStringResId(R.string.guonei)));
        newsTabList.add(new NewsTab("guoji", ResourceUtils.fromStringResId(R.string.guoji)));
        newsTabList.add(new NewsTab("yule", ResourceUtils.fromStringResId(R.string.yule)));
        newsTabList.add(new NewsTab("tiyu", ResourceUtils.fromStringResId(R.string.tiyu)));
        newsTabList.add(new NewsTab("junshi", ResourceUtils.fromStringResId(R.string.junshi)));
        newsTabList.add(new NewsTab("keji", ResourceUtils.fromStringResId(R.string.keji)));
        newsTabList.add(new NewsTab("caijing", ResourceUtils.fromStringResId(R.string.caijing)));
        newsTabList.add(new NewsTab("shishang", ResourceUtils.fromStringResId(R.string.shishang)));

        return newsTabList;
    }
}
