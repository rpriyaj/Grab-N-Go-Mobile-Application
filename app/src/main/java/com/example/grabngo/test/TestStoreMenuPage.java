package com.example.grabngo.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.grabngo.R;
import com.example.grabngo.controllers.AddOnPage;
import com.example.grabngo.models.Food;

// TODO: Unsure of some below
// Function: For users to choose food item from selected store
// Input: TimeSlot? StallID? (setContentView to layout/store_menu_page.xml
// Output: TimeSlot? StallID? FoodID? (redirect page)
// Sent/Read from DB: None
// Prev Page Link: ChooseStorePage1/2.java
// Next Page Link: AddOnPage
// Java Concepts/OOP: Intent(?)

public class TestStoreMenuPage extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_menu_page);

        // BUTTON HANDLER
        // I tried to do out of normal and its still pretty repetitive and long
        // But at least its clear what I'm doing and can add more buttons
        ImageButton add1 = (ImageButton) findViewById(R.id.AddButton1);
        ImageButton add2 = (ImageButton) findViewById(R.id.AddButton2);
        ImageButton add3 = (ImageButton) findViewById(R.id.AddButton3);
        ImageButton subtract1 = (ImageButton) findViewById(R.id.MinusButton1);
        ImageButton subtract2 = (ImageButton) findViewById(R.id.MinusButton2);
        ImageButton subtract3 = (ImageButton) findViewById(R.id.MinusButton3);
        ImageButton addon1 = findViewById(R.id.ArrowButton1);
        ImageButton addon2 = findViewById(R.id.ArrowButton2);
        ImageButton addon3 = findViewById(R.id.ArrowButton3);

        add1.setOnClickListener(this);
        add2.setOnClickListener(this);
        add3.setOnClickListener(this);
        subtract1.setOnClickListener(this);
        subtract2.setOnClickListener(this);
        subtract3.setOnClickListener(this);
        addon1.setOnClickListener(this);
        addon2.setOnClickListener(this);
        addon3.setOnClickListener(this);

        Log.d("TEST!", "TESTING TESTING TESTING TESTING TESTING!");

        // Testing FoodBuilder
        Food chickenrice1 = new Food.FoodBuilder("Steamed Chicken Rice", 4.80)
                .setAddMeat(true).build();

        Food chickenrice2 = new Food.FoodBuilder("Roasted Chicken Rice", 5.80)
                .setAddEgg(true).build();

        Food chickenrice3 = new Food.FoodBuilder("Roasted Chicken Rice Set Meal", 9.90)
                .build();

        Log.d("Test FoddBuilder OBJECT 1", chickenrice1.getFood_name() + " " + chickenrice1.getFood_price() +
                "\nAdd Meat? " + chickenrice1.isAddMeat() + " Add Egg? " + chickenrice1.isAddEgg() + " Add Tofu? " + chickenrice1.isAddTofu());

        Log.d("Test FoddBuilder OBJECT 2", chickenrice2.getFood_name() + " " + chickenrice2.getFood_price() +
                "\nAdd Meat? " + chickenrice2.isAddMeat() + " Add Egg? " + chickenrice2.isAddEgg() + " Add Tofu? " + chickenrice2.isAddTofu());

        Log.d("Test FoddBuilder OBJECT 3", chickenrice3.getFood_name() + " " + chickenrice3.getFood_price() +
                "\nAdd Meat? " + chickenrice3.isAddMeat() + " Add Egg? " + chickenrice3.isAddEgg() + " Add Tofu? " + chickenrice3.isAddTofu());
    }

    public void onClick(View view) {
        TextView quantity1 = findViewById(R.id.MenuItem1Quantity);
        int count1 = Integer.valueOf(quantity1.getText().toString());
        TextView quantity2 = findViewById(R.id.MenuItem2Quantity);
        int count2 = Integer.valueOf(quantity2.getText().toString());
        TextView quantity3 = findViewById(R.id.MenuItem3Quantity);
        int count3 = Integer.valueOf(quantity3.getText().toString());

        int overall_count = count1 + count2 + count3;

        Intent addon = new Intent(view.getContext(), AddOnPage.class);

        switch (view.getId()) {
            case R.id.AddButton1:
                if (overall_count < 1) {
                    overall_count++;
                    count1++;
                    quantity1.setText(String.valueOf(count1));
                }
                if (count1 > 0) {
                    findViewById(R.id.ArrowButton1).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.ArrowButton1).setVisibility(View.GONE);
                }
                break;
            case R.id.MinusButton1:
                if (count1 > 0) {
                    overall_count--;
                    count1--;
                    quantity1.setText(String.valueOf(count1));
                }
                if (count1 > 0) {
                    findViewById(R.id.ArrowButton1).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.ArrowButton1).setVisibility(View.GONE);
                }
                break;
            case R.id.ArrowButton1:
                view.getContext().startActivity(addon);
                break;
            case R.id.AddButton2:
                if (overall_count < 1) {
                    overall_count++;
                    count2++;
                    quantity2.setText(String.valueOf(count2));
                }
                if (count2 > 0) {
                    findViewById(R.id.ArrowButton2).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.ArrowButton2).setVisibility(View.GONE);
                }
                break;
            case R.id.MinusButton2:
                if (count2 > 0) {
                    overall_count--;
                    count2--;
                    quantity2.setText(String.valueOf(count2));
                }
                if (count2 > 0) {
                    findViewById(R.id.ArrowButton2).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.ArrowButton2).setVisibility(View.GONE);
                }
                break;
            case R.id.ArrowButton2:
                view.getContext().startActivity(addon);
                break;
            case R.id.AddButton3:
                if (overall_count < 1) {
                    overall_count++;
                    count3++;
                    quantity3.setText(String.valueOf(count3));
                }
                if (count3 > 0) {
                    findViewById(R.id.ArrowButton3).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.ArrowButton3).setVisibility(View.GONE);
                }
                break;
            case R.id.MinusButton3:
                if (count3 > 0) {
                    overall_count--;
                    count3--;
                    quantity3.setText(String.valueOf(count3));
                }
                if (count3 > 0) {
                    findViewById(R.id.ArrowButton3).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.ArrowButton3).setVisibility(View.GONE);
                }
                break;
            case R.id.ArrowButton3:
                view.getContext().startActivity(addon);
                break;
            default:
                break;
        }
    }
}