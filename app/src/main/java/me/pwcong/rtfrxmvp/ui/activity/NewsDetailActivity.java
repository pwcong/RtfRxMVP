package me.pwcong.rtfrxmvp.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding.support.v4.widget.RxSwipeRefreshLayout;
import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.presenter.NewsDetailActivityPresenter;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import me.pwcong.rtfrxmvp.utils.ActivityUtils;
import rx.functions.Action1;

/**
 * Created by pwcong on 2016/8/23.
 */
public class NewsDetailActivity extends BaseActivity implements BaseView.NewsDetailActivityView {

    private final String TAG=getClass().getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_img)
    ImageView iv_img;
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout refreshLayout;
    @BindView(R.id.web_view)
    WebView webView;

    String title;
    String url_content;
    String url_img;

    NewsDetailActivityPresenter presenter;

    @Override
    protected int getContentView() {
        return R.layout.activity_newsdetail;
    }

    @Override
    protected void initVariable() {

        presenter=new NewsDetailActivityPresenter(this);

        initBundleValue();
        initToolbar();
        initWebView();

        RxToolbar.navigationClicks(toolbar).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                finish();
            }
        });

        RxSwipeRefreshLayout.refreshes(refreshLayout).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                presenter.loadData();
            }
        });

        Log.i(TAG, "initVariable: ok");

    }

    private void initToolbar(){

        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_left_white_24dp);

    }


    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView(){
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                hideProgress();
            }
        });
    }

    private void initBundleValue(){
        Bundle bundle = getIntent().getExtras();
        title=bundle.getString(Constants.TITLE);
        url_content=bundle.getString(Constants.URL_CONTENT);
        url_img=bundle.getString(Constants.URL_IMG);
    }

    @Override
    protected void doAction() {
        presenter.loadData();
        Log.i(TAG, "doAction: ok");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.menu_share,menu);
        Log.i(TAG, "onCreateOptionsMenu: ok");
        
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        presenter.onMenuItemInteraction(item.getItemId());
        Log.i(TAG, "onOptionsItemSelected: ok");
        return true;
    }

    @Override
    public void loadData() {

        Glide.with(this)
                .load(url_img)
                .centerCrop()
                .into(iv_img);

        webView.loadUrl(url_content);
        Log.i(TAG, "loadData: ok");
    }

    @Override
    public void shareData() {
        ActivityUtils.share(url_content);
        Log.i(TAG, "shareDetail: "+url_content);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgress() {
        refreshLayout.setRefreshing(true);
        Log.i(TAG, "showProgress: ok");
    }

    @Override
    public void hideProgress() {
        refreshLayout.setRefreshing(false);
        Log.i(TAG, "hideProgress: ok");
    }
}
