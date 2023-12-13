package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FoodItemAdapter extends FragmentPagerAdapter {

    // Variable to store the number of tabs
    int tabCounts;

    // Constructor to initialize the adapter with the fragment manager and tab count
    public FoodItemAdapter(@NonNull FragmentManager fm, int tabCounts) {
        super(fm);
        this.tabCounts = tabCounts;
    }

    // Return the fragment associated with a specified position
    @NonNull
    @Override
    public Fragment getItem(int position) {
        // Return the appropriate fragment for each position
        switch (position) {
            case 0:
                return new FoodsFragment(); // Fragment for the "Foods" tab
            case 1:
                return new DrinksFragment(); // Fragment for the "Drinks" tab
            case 2:
                return new SnacksFragment(); // Fragment for the "Snacks" tab
            default:
                return null; // Return null if an invalid position is provided
        }
    }

    // Return the number of tabs
    @Override
    public int getCount() {
        // Return the total number of tabs
        return 3;
    }
}
