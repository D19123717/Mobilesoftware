package com.example.foodorderapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        tabLayout = findViewById(R.id.food_tab);
        viewPager = findViewById(R.id.food_viewpager);

        tabLayout.addTab(tabLayout.newTab().setText("Foods"));     //0
        tabLayout.addTab(tabLayout.newTab().setText("Drinks"));    //1
        tabLayout.addTab(tabLayout.newTab().setText("Snacks"));    //2
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final FoodItemAdapter adapter = new FoodItemAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


}
