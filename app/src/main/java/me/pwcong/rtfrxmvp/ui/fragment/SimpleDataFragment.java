package me.pwcong.rtfrxmvp.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.adapter.SimpleDataAdapter;

/**
 * Created by pwcong on 2016/8/20.
 */
public class SimpleDataFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void initVariable() {

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new SimpleDataAdapter(SimpleDataAdapter.getSimpleData()));

    }

    @Override
    protected void doAction() {

    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_simpledata;
    }
}
