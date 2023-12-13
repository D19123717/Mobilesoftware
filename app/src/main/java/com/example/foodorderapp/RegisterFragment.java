package com.example.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import database.AppDatabase;
import database.UserDAO;
import models.User;

public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        // Reference to UI components
        EditText editTextName = view.findViewById(R.id.name_txt);
        EditText editTextEmail = view.findViewById(R.id.email_txt);
        EditText editTextPhone = view.findViewById(R.id.phone_txt);
        EditText editTextPassword = view.findViewById(R.id.password_txt);
        Button registerButton = view.findViewById(R.id.register_btn);

        // Handle registration button click
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve user input
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String phone = editTextPhone.getText().toString();
                String password = editTextPassword.getText().toString();

                // Validate user input (you may add more validation)
                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {

                    // get the current fragment and put it in the database
                    AppDatabase db = AppDatabase.getDatabase(getActivity().getApplicationContext());
                    UserDAO userDAO = db.getUserDAO();
                    User user = new User();
                    user.setName(name);
                    user.setEmail(email);
                    user.setPhone(phone);
                    user.setPassword(password);
                    userDAO.insert(user);

//                    Log.e("Displaying users", (userDAO.getUsers()).toString());

                    for (User u : userDAO.getUsers()) {
                        Log.e("Displaying users Email", u.getEmail());
                        Log.e("Displaying users Password", u.getPassword());
                    }

                    // a toast message for a successful registration
                    String message = "Registration successful\n" +
                            "Name: " + name + "\n" +
                            "Email: " + email + "\n" +
                            "Phone: " + phone + "\n" +
                            "Password: " + password;

                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();

                    // After successful registration, you will navigate to another activity
                    // that is the DashboardActivity
                    Intent intent = new Intent(getActivity(), DashboardActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}