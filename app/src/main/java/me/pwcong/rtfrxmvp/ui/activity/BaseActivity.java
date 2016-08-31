package me.pwcong.rtfrxmvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import me.pwcong.rtfrxmvp.manager.ActivityManager;

/**
 * Created by pwcong on 2016/8/19.
 */
public abstract class BaseActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityManager.getInstance().register(this);

        setContentView(getContentView());

        ButterKnife.bind(this);

        initVariable();

        doAction();

    }

    protected abstract int getContentView();

    protected abstract void initVariable();

    protected abstract void doAction();

    public void showSnackBar(View view,String message){
        Snackbar.make(view,message,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().unregister(this);
    }
}
