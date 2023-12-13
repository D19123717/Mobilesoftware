package com.example.foodorderapp;

public class FoodItemModel {

    // Declare variables to store food item details
    int food_image;
    String food_name, food_price;

    // Default constructor (empty)
    public FoodItemModel() {
    }

    // Parameterized constructor to initialize the food item
    public FoodItemModel(int food_image, String food_name, String food_price) {
        this.food_image = food_image;
        this.food_name = food_name;
        this.food_price = food_price;
    }

    // Getter method for food image
    public int getFood_image() {
        return food_image;
    }

    // Setter method for food image
    public void setFood_image(int food_image) {
        this.food_image = food_image;
    }

    // Getter method for food name
    public String getFood_name() {
        return food_name;
    }

    // Setter method for food name
    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    // Getter method for food price
    public String getFood_price() {
        return food_price;
    }

    // Setter method for food price
    public void setFood_price(String food_price) {
        this.food_price = food_price;
    }
}
