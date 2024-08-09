package me.pwcong.rtfrxmvp.component.activity;

import android.support.v7.widget.Toolbar;

import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.component.fragment.SettingFragment;
import rx.functions.Action1;

/**
 * Created by pwcong on 2016/8/31.
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getContentView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initVariable() {
        initToolbar();
    }

    private void initToolbar() {

        mToolbar.setTitle(R.string.setting);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.arrow_left);
        RxToolbar.navigationClicks(mToolbar).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                finish();
            }
        });

    }

    @Override
    protected void doAction() {

        getFragmentManager().beginTransaction().replace(R.id.content, new SettingFragment()).commit();

    }
}
