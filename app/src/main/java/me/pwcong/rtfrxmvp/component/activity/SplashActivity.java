package me.pwcong.rtfrxmvp.component.activity;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by pwcong on 2016/8/28.
 */
public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_bg)
    ImageView iv_bg;
    @BindView(R.id.iv_appname)
    ImageView iv_appname;

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initVariable() {

        iv_bg.setAnimation(getScaleAnimation());
        iv_appname.setAnimation(getAlphaAnimation());

        Observable.timer(2000,TimeUnit.MILLISECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                redirectToMainActivity();
            }
        });


    }

    @Override
    protected void doAction() {

    }

    private ScaleAnimation getScaleAnimation(){

        ScaleAnimation animation=new ScaleAnimation(1.0f,1.0f,1.01f,1.01f,Animation.RELATIVE_TO_SELF,Animation.RELATIVE_TO_SELF);
        animation.setDuration(1500);
        animation.setFillAfter(true);
        return animation;
    }

    private AlphaAnimation getAlphaAnimation(){

        AlphaAnimation animation=new AlphaAnimation(0,1);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        return  animation;

    }

    private void redirectToMainActivity(){

        startActivity(new Intent(this,MainActivity.class));
        finish();

    }

}
