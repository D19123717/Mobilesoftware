package com.example.foodorderapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodsFragment extends Fragment {

    // Declare UI components and variables
    RecyclerView recyclerView;
    FoodAdapter foodAdapter;
    List<FoodItemModel> list;

    // Required empty public constructor
    public FoodsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Additional setup can be done here if needed
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foods, container, false);

        // Initialize the list of food items
        list = new ArrayList<>();
        list.add(new FoodItemModel(R.drawable.img1, "Fried Rice", "Rs: £20.80"));
        list.add(new FoodItemModel(R.drawable.img2, "Ramen Noodles", "Rs: £20.80"));
        list.add(new FoodItemModel(R.drawable.img3, "Fish and chips", "Rs: £20.80"));
        list.add(new FoodItemModel(R.drawable.img4, "Pizza", "Rs: £20.80"));
        list.add(new FoodItemModel(R.drawable.img5, "Egusi and poudo", "Rs: £20.80"));
        list.add(new FoodItemModel(R.drawable.img6, "Double bun burger and chips", "Rs: £20.80"));

        // Create a new FoodAdapter and pass the list of food items
        foodAdapter = new FoodAdapter(list, getActivity().getApplicationContext());

        // Find the RecyclerView in the layout
        recyclerView = view.findViewById(R.id.recyclerViewFoods);

        // Set up the layout manager for the RecyclerView (Horizontal LinearLayoutManager)
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);

        // Set the RecyclerView to have a fixed size
        recyclerView.setHasFixedSize(true);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(foodAdapter);

        // Return the prepared view for this fragment
        return view;
    }
}
