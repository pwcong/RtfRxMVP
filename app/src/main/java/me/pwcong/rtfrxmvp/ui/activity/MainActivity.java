package me.pwcong.rtfrxmvp.ui.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jakewharton.rxbinding.support.design.widget.RxNavigationView;
import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;

import java.util.Calendar;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.citypicker.CityPickerActivity;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.manager.ActivityManager;
import me.pwcong.rtfrxmvp.manager.SharedPreferencesManager;
import me.pwcong.rtfrxmvp.mvp.presenter.BasePresenter;
import me.pwcong.rtfrxmvp.mvp.presenter.MainActivityPresenterImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import me.pwcong.rtfrxmvp.ui.fragment.JokeFragment;
import me.pwcong.rtfrxmvp.ui.fragment.NewsTabFragment;
import me.pwcong.rtfrxmvp.ui.fragment.WeatherFragment;
import me.pwcong.rtfrxmvp.utils.TimeUtils;
import rx.functions.Action1;

/**
 * Created by pwcong on 2016/8/19.
 */
public class MainActivity extends BaseActivity implements BaseView.MainActivityView{

    private  final String TAG=getClass().getSimpleName();

    public static final int REQUEST_CODE=100;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    BasePresenter.MainActivityPresenter presenter;

    int currentNavigationItemSelectedId;
    long mExitTime;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariable() {

        presenter=new MainActivityPresenterImpl(this);

        initToolbar();

        initDrawerLayout();

        initNavigationView();

        Log.i(TAG, "initVariable: OK");

    }

    private void initToolbar(){

        toolbar.setTitle(R.string.navigation_item_newspaper);
        setSupportActionBar(toolbar);
        RxToolbar.itemClicks(toolbar).subscribe(new Action1<MenuItem>() {
            @Override
            public void call(MenuItem menuItem) {
                presenter.onMenuItemIntrraction(menuItem.getItemId());
            }
        });
    }


    private void initDrawerLayout(){

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initNavigationView(){

        View headerView = navigationView.getHeaderView(0);
        ImageView iv_nav_header= (ImageView) headerView.findViewById(R.id.iv_nav_header);

        int hours = Calendar.getInstance().get(Calendar.HOUR);
        Log.e(TAG, "initNavigationView: " +hours );

        if(hours>6&&hours<18){
            Glide.with(this).load(R.drawable.header_day).into(iv_nav_header);
        }else {
            Glide.with(this).load(R.drawable.header_night).into(iv_nav_header);
        }

        navigationView.setCheckedItem(R.id.item_newspaper);
        RxNavigationView.itemSelections(navigationView).subscribe(new Action1<MenuItem>() {
            @Override
            public void call(MenuItem menuItem) {
                currentNavigationItemSelectedId=menuItem.getItemId();
                presenter.onNavigationItemInteraction(menuItem.getItemId());
            }
        });

    }


    @Override
    protected void doAction() {

        presenter.initContent();
        Log.i(TAG, "doAction: OK");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        Log.i(TAG, "onCreateOptionsMenu: OK");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void startCityPickerActivityForResult() {
        startActivityForResult(new Intent(MainActivity.this, CityPickerActivity.class),REQUEST_CODE);
        Log.i(TAG, "startCityPickerActivityForResult: OK");
    }

    @Override
    public void switchNews() {

        toolbar.setTitle(R.string.navigation_item_newspaper);
        getSupportFragmentManager().beginTransaction().replace(R.id.content,new NewsTabFragment()).commit();
        drawerLayout.closeDrawer(GravityCompat.START);

        Log.i(TAG, "switchNews: OK");
    }

    @Override
    public void switchWeather(String cityname) {


        toolbar.setTitle(R.string.navigation_item_weather);
        drawerLayout.closeDrawer(GravityCompat.START);

        getSupportFragmentManager().beginTransaction().replace(R.id.content, WeatherFragment.getInstance(cityname)).commit();

        Log.i(TAG, "switchWeather: OK");

    }

    @Override
    public void switchJoke() {

        toolbar.setTitle(R.string.joke);
        drawerLayout.closeDrawer(GravityCompat.START);
        getSupportFragmentManager().beginTransaction().replace(R.id.content,new JokeFragment()).commit();
        Log.i(TAG, "switchJoke: OK");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK&&requestCode==REQUEST_CODE){

            String cityname = data.getExtras().getString(Constants.CITY_NAME);

            SharedPreferencesManager.getInstance().edit().putString(Constants.CITY_NAME,cityname).commit();

            if(currentNavigationItemSelectedId==R.id.item_weather){
                switchWeather(cityname);
            }


        }

        Log.i(TAG, "onActivityResult: OK");

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {

                showSnackBar(toolbar,"再按一次退出程序");

                mExitTime = System.currentTimeMillis();

            } else {
                ActivityManager.getInstance().removeAll();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

}
