package com.example.foodorderapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodDetailActivity extends AppCompatActivity {

    // Declare UI components
    ImageView food_back;
    TextView food_name, food_price;
    ImageView food_image;
    TextView ordernow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        // Initialize UI components and set up the "Back" button
        food_back = findViewById(R.id.food_back);
        food_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // Retrieve data from the Intent
        Intent intent = getIntent();

        // Initialize TextViews and ImageView to display food details
        food_name = findViewById(R.id.food_name);
        food_price = findViewById(R.id.food_price);
        food_image = findViewById(R.id.food_image);

        // Set the text and image based on the received data from the Intent
        food_name.setText(intent.getStringExtra("food_name"));
        food_price.setText(intent.getStringExtra("food_price"));
        food_image.setImageResource(intent.getIntExtra("food_image", R.drawable.img1));

        // Set up the "Order Now" button with an email intent
        ordernow = findViewById(R.id.food_order);
        ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an email intent for placing an order
                Intent orderFood = new Intent(Intent.ACTION_SENDTO);
                orderFood.setData(Uri.parse("mailto:"));
                String[] email = {"YourEmail@gmail.com", "", ""};
                String subject = "New Order for " + intent.getStringExtra("food_name") + "!";
                String text = "Order Details \n\n " + "Food Name: " + intent.getStringExtra("food_name")
                        + "\nFood Price: " + intent.getStringExtra("food_price")
                        + "\nAddress: ";
                orderFood.putExtra(Intent.EXTRA_EMAIL, email);
                orderFood.putExtra(Intent.EXTRA_SUBJECT, subject);
                orderFood.putExtra(Intent.EXTRA_TEXT, text);

                // Check if there's an app to handle the email intent
                if (orderFood.resolveActivity(getApplicationContext().getPackageManager()) != null) {
                    startActivity(orderFood);
                }
            }
        });
    }
}
