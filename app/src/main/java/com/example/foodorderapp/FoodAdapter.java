package com.example.foodorderapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    // Declare necessary variables
    List<FoodItemModel> list;
    Context context;

    // Constructor to initialize the adapter with a list of food items and a context
    public FoodAdapter(List<FoodItemModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a food item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item_layout, parent, false);
        return new FoodViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        // Set the data for each food item in the corresponding view holder
        holder.food_image.setImageResource(list.get(position).food_image);
        holder.food_name.setText(list.get(position).food_name);
        holder.food_price.setText(list.get(position).food_price);

        // Set a click listener to handle item clicks
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    // Create an intent to start the FoodDetailActivity and pass relevant data
                    Intent intent = new Intent(context, FoodDetailActivity.class);
                    intent.putExtra("food_name", list.get(adapterPosition).getFood_name());
                    intent.putExtra("food_price", list.get(adapterPosition).getFood_price());
                    intent.putExtra("food_image", list.get(adapterPosition).getFood_image());
                    context.startActivity(intent);
                }
            }
        });
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }

    // Provide a reference to the views for each data item
    public class FoodViewHolder extends RecyclerView.ViewHolder {

        // Declare views for each item in the food list
        ImageView food_image;
        TextView food_name, food_price;
        View view;

        // Constructor to initialize the views
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            food_image = itemView.findViewById(R.id.food_image);
            food_name = itemView.findViewById(R.id.food_name);
            food_price = itemView.findViewById(R.id.food_price);
        }
    }
}
