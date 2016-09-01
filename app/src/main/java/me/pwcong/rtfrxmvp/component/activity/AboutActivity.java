package me.pwcong.rtfrxmvp.component.activity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;
import com.jakewharton.rxbinding.view.RxView;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.utils.ActivityUtils;
import me.pwcong.rtfrxmvp.utils.ResourceUtils;
import rx.functions.Action1;

/**
 * Created by pwcong on 2016/8/31.
 */
public class AboutActivity extends BaseActivity {

    private final String TAG=getClass().getSimpleName();

    @BindView(R.id.link_source)
    LinearLayout mLinkSource;
    @BindView(R.id.link_blog)
    LinearLayout mLinkBlog;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;


    @Override
    protected int getContentView() {
        return R.layout.activity_about;
    }

    @Override
    protected void initVariable() {

        initToolbar();
        initLinkView();

        Log.i(TAG, "initVariable: OK");
        
    }


    private void initToolbar(){

        mToolbar.setTitle(R.string.app_name);
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationIcon(R.drawable.arrow_left);
        RxToolbar.navigationClicks(mToolbar).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                finish();
            }
        });
        
    }

    private void initLinkView(){

        RxView.clicks(mLinkSource).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                ActivityUtils.openUrl(ResourceUtils.fromStringResId(R.string.url_source));
            }
        });

        RxView.clicks(mLinkBlog).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                ActivityUtils.openUrl(ResourceUtils.fromStringResId(R.string.url_blog));
            }
        });

    }


    @Override
    protected void doAction() {}

}
