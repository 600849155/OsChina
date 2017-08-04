package com.example.administrator.oschina.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TabHost;

import com.astuetz.PagerSlidingTabStrip;
import com.example.administrator.oschina.R;
import com.example.administrator.oschina.adapter.MyFragmentViewAdapter;
import com.example.administrator.oschina.fragment.ListViewFragment;
import com.example.administrator.oschina.widget.MyFragmentTabHost;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, TabHost.OnTabChangeListener, View.OnTouchListener {

    @InjectView(android.R.id.tabhost)
    public MyFragmentTabHost mTabHost;

    @InjectView(R.id.quick_option_iv)
    View mAddBt;

    //建两个全局变量，等下用它们获取layout里面的两个控件
    private ViewPager vp;
    private PagerSlidingTabStrip pst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initView();

    }

    private void initView() {


        initTabs();

//        // 中间按键图片触发
//        mAddBt.setOnClickListener(this);
//        mAddBt.setOnLongClickListener(new View.OnLongClickListener() {
//
//            @Override
//            public boolean onLongClick(View v) {
//                return true;
//            }
//        });
//
//        mTabHost.setCurrentTab(0);
//        mTabHost.setOnTabChangedListener(this);






    }




    private void initTabs() {
        //用上面的两个全局变量find到控件
        vp = (ViewPager) findViewById(R.id.viewpager);
        pst = (PagerSlidingTabStrip) findViewById(R.id.pst);
        //建一个List，泛型设为Fragment，用来存放Fragment
        List<Fragment> list = new ArrayList<>();
        //建一个存放字符串的List，这里是为了用第三方工具PagerSlidingTabStrip而弄的，因为要往里面穿一些参数。
        //最后呈现的是上方的可点击指示器
        List<String> title = new ArrayList<>();
        title.add("资讯");
        title.add("热点");
        title.add("博客");
        title.add("推荐");


        //来个循环，我这里弄了五次，建了5个ListViewFragment，并且往ListViewFragment里捆绑了一些整数，用于判断
        //并区分多种新闻内容
        for(int i = 1;i<=4;i++){
            Fragment fragment = new ListViewFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg",i);
            fragment.setArguments(bundle);
            list.add(fragment);
        }

        //将存放了Fragment的列表和指示器的参量加载到适配器中，然后将适配器变量加载到ViewPager中
        //最后将ViewPager放到布局的PagerSlidingTabStrip第三方控件里
        MyFragmentViewAdapter ma = new MyFragmentViewAdapter(getSupportFragmentManager(),list,title);
        vp.setAdapter(ma);
        pst.setViewPager(vp);


    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onTabChanged(String s) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
