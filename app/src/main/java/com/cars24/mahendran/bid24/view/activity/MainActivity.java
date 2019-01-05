package com.cars24.mahendran.bid24.view.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.cars24.mahendran.bid24.R;
import com.cars24.mahendran.bid24.model.CarObject;
import com.cars24.mahendran.bid24.view.adaptor.PagerAdaptor;
import com.cars24.mahendran.bid24.view.adaptor.RealmCarsAdaptor;

import java.util.ArrayList;
import java.util.Calendar;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.exceptions.RealmMigrationNeededException;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    static MainActivity instance;
    private String[] names;
    private FrameLayout frameLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setInstance(this);
        Realm.init(getInstance());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary));
        tabLayout.setSelectedTabIndicatorHeight(0);
        viewPager = findViewById(R.id.pager);
        names = new String[]{"Cars List", "User"};

        int[] icons = { R.mipmap.ic_launcher, R.mipmap.ic_launcher};

        for (int i = 0; i < names.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setIcon(icons[i]).setTag(names[i]));
        }

        pagerAdapter = new PagerAdaptor(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(this);
        viewPager.setCurrentItem(0, false);
        if (viewPager.getCurrentItem() == 0) {
            setTitle(names[0]);
        }

        viewPager.setOffscreenPageLimit(4);

    }

    public static MainActivity getInstance() {
        return instance;
    }

    public static void setInstance(MainActivity instance) {
        MainActivity.instance = instance;
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    public  Realm getRealmInstance() {
        try {
            return Realm.getDefaultInstance();
        } catch (RealmMigrationNeededException e) {
            try {
                return Realm.getDefaultInstance();
            } catch (Exception ex) {
                return Realm.getDefaultInstance();
                //No Realm file to remove.
            }
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition(), false);
        setTitle(names[tab.getPosition()]);

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
