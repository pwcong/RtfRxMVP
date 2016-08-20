package me.pwcong.rtfrxmvp.mvp.model;

import java.util.ArrayList;
import java.util.List;

import me.pwcong.rtfrxmvp.mvp.bean.FragmentWithTitle;
import me.pwcong.rtfrxmvp.ui.fragment.SimpleDataFragment;

/**
 * Created by pwcong on 2016/8/20.
 */
public class NewsFragmentTabModelImpl implements BaseModel.NewsFragmentTabModel {

    @Override
    public void setData(BaseDataBridge<FragmentWithTitle> dataBridge) {

        List<FragmentWithTitle> fragmentWithTitleList=new ArrayList<>();
        fragmentWithTitleList.add(new FragmentWithTitle(new SimpleDataFragment(),"Hello 1"));
        fragmentWithTitleList.add(new FragmentWithTitle(new SimpleDataFragment(),"Hello 2"));
        fragmentWithTitleList.add(new FragmentWithTitle(new SimpleDataFragment(),"Hello 3"));
        fragmentWithTitleList.add(new FragmentWithTitle(new SimpleDataFragment(),"Hello 4"));
        fragmentWithTitleList.add(new FragmentWithTitle(new SimpleDataFragment(),"Hello 5"));
        fragmentWithTitleList.add(new FragmentWithTitle(new SimpleDataFragment(),"Hello 6"));
        fragmentWithTitleList.add(new FragmentWithTitle(new SimpleDataFragment(),"Hello 7"));

        dataBridge.setData(fragmentWithTitleList);

    }
}
