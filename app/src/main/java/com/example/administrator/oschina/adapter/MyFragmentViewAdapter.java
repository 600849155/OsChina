package com.example.administrator.oschina.adapter;

/**
 * Created by Administrator on 2017-8-3.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017-5-22.
 */
public class MyFragmentViewAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> title;


    public MyFragmentViewAdapter(FragmentManager fm, List<Fragment> list, List<String> title) {
        super(fm);
        this.title = title;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

}

