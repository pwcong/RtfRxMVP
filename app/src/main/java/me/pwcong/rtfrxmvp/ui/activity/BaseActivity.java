package me.pwcong.rtfrxmvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by pwcong on 2016/8/19.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentView());

        ButterKnife.bind(this);

        initVariable();

        doAction();

    }

    protected abstract int getContentView();

    protected abstract void initVariable();

    protected abstract void doAction();

    public void SnackBar(View view,String message){
        Snackbar.make(view,message,Snackbar.LENGTH_SHORT).show();

    }




}
