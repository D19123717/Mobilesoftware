package com.example.foodorderapp;

// DrinksFragment.java
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class DrinksFragment extends Fragment {

    // Declare necessary variables
    RecyclerView recyclerView;
    FoodAdapter drinksAdapter; // Assuming you reuse the FoodAdapter
    List<FoodItemModel> drinksList;

    // Empty constructor is required for fragments
    public DrinksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drinks, container, false);

        // Initialize the list of drinks data
        drinksList = new ArrayList<>();
        drinksList.add(new FoodItemModel(R.drawable.drings1, "Iced Coffee", "Rs: £10.50"));
        drinksList.add(new FoodItemModel(R.drawable.drinks2, "Fruit Smoothie", "Rs: £5.00"));
        drinksList.add(new FoodItemModel(R.drawable.drinks3, "Soda", "Rs: £2.89"));

        // Assuming you reuse the FoodAdapter
        drinksAdapter = new FoodAdapter(drinksList, getActivity().getApplicationContext());

        // Find the RecyclerView in the layout
        recyclerView = view.findViewById(R.id.recyclerViewDrinks);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(drinksAdapter);

        // Set up the layout manager for the RecyclerView (Horizontal LinearLayoutManager)
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);

        // Set the RecyclerView to have a fixed size
        recyclerView.setHasFixedSize(true);

        // Return the prepared view for this fragment
        return view;
    }
}
