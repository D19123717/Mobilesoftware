package com.example.foodorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a click listener for the "Get Started" text
        findViewById(R.id.get_started_txt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When the "Get Started" text is clicked, create an intent to start the LoginActivity
                Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginIntent);

                // Finish the current activity to prevent navigating back to it
                finish();
            }
        });
    }
}
