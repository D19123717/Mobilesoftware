package com.example.foodorderapp;

// SnacksFragment.java
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SnacksFragment extends Fragment {

    RecyclerView recyclerView;
    FoodAdapter snacksAdapter; // Assuming you reuse the FoodAdapter
    List<FoodItemModel> snacksList;

    public SnacksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_snacks, container, false);

        // Initialize your snacks data (similar to what you did for foods)
        snacksList = new ArrayList<>();
        snacksList.add(new FoodItemModel(R.drawable.chips, "Chips", "Rs: £14.50"));
        snacksList.add(new FoodItemModel(R.drawable.pop, "Popcorn", "Rs: £3.00"));
        snacksList.add(new FoodItemModel(R.drawable.nacho, "Nachos", "Rs: £15.90"));

        // Assuming you reuse the FoodAdapter
        snacksAdapter = new FoodAdapter(snacksList, getActivity().getApplicationContext());

        recyclerView = view.findViewById(R.id.recyclerViewSnacks); // Make sure to find the RecyclerView in your layout
        recyclerView.setAdapter(snacksAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        return view;
    }
}


