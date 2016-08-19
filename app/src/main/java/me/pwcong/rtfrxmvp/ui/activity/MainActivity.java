package me.pwcong.rtfrxmvp.ui.activity;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import butterknife.BindView;
import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.ui.fragment.TestFragment;

/**
 * Created by pwcong on 2016/8/19.
 */
public class MainActivity extends BaseActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariable() {

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



    }

    @Override
    protected void doAction() {

        getSupportFragmentManager().beginTransaction().replace(R.id.content,new TestFragment()).commit();

    }
}
