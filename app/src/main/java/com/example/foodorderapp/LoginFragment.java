package com.example.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    // Default constructor
    public LoginFragment() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Set a click listener for the login button
        view.findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the login button is clicked, create an intent to start the DashboardActivity
                Intent intent = new Intent(getActivity().getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
            }
        });

        // Return the prepared view for this fragment
        return view;
    }
}
