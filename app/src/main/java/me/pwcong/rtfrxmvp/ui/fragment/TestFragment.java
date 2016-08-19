package me.pwcong.rtfrxmvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.SimpleAdapter;

/**
 * Created by pwcong on 2016/8/19.
 */
public class TestFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected void initVariable() {

        List<String> stringList=new ArrayList<>();
        for(int i=0;i<50;i++){
            stringList.add("HelloWorld "+i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new SimpleAdapter(stringList));



    }

    @Override
    protected void doAction() {

    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_test;
    }
}
