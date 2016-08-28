package me.pwcong.rtfrxmvp.ui.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.jakewharton.rxbinding.support.design.widget.RxNavigationView;
import com.jakewharton.rxbinding.support.v7.widget.RxToolbar;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.citypicker.CityPickerActivity;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.manager.SharedPrefrerncesManager;
import me.pwcong.rtfrxmvp.mvp.presenter.MainActivityPresenterImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import me.pwcong.rtfrxmvp.ui.fragment.NewsTabFragment;
import me.pwcong.rtfrxmvp.ui.fragment.WeatherFragment;
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

    MainActivityPresenterImpl presenter;
    int currentNavigationItemSelectedId;

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK&&requestCode==REQUEST_CODE){

            String cityname = data.getExtras().getString(Constants.CITY_NAME);

            SharedPrefrerncesManager.getInstance().edit().putString(Constants.CITY_NAME,cityname).commit();

            if(currentNavigationItemSelectedId==R.id.item_weather){
                switchWeather(cityname);
            }


        }

        Log.i(TAG, "onActivityResult: OK");

    }
}
