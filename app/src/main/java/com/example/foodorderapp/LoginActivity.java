package com.example.foodorderapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    // Declare UI components
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find TabLayout and ViewPager in the layout
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // Add tabs to the TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Login"));    // Tab 0
        tabLayout.addTab(tabLayout.newTab().setText("SignUp"));   // Tab 1
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // Create an adapter for managing fragments in the ViewPager
        final FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        // Set a listener to update the selected tab when the ViewPager is swiped
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // Set a listener to update the current tab when a tab is selected in the TabLayout
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // Unused method, can be left empty
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Unused method, can be left empty
            }
        });
    }
}
