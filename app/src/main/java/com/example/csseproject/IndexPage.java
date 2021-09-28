package com.example.csseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.csseproject.HomeBottomNav.HomeBottomNav;
import com.example.csseproject.HomePage.HomePage;
import com.example.csseproject.HomePage.Model.OrderModel;

public class IndexPage extends AppCompatActivity {

    Button settingButton;
    Button BottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingButton = findViewById(R.id.order_list);
        BottomNav = findViewById(R.id.bottomNav);


        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HomePage.class);
                view.getContext().startActivity(intent);
            }
        });
        BottomNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HomeBottomNav.class);
                view.getContext().startActivity(intent);
            }
        });

    }
}