package com.example.csseproject.HomeBottomNav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.csseproject.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeBottomNav extends AppCompatActivity {

    NavigationController Nav = new NavigationController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_bottom_nav);

        BottomNavigationView bottomNavView  = findViewById(R.id.bottom_nav);
        bottomNavView.setOnNavigationItemSelectedListener( navListener);

        Menu menu = bottomNavView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent change =  Nav.ChangeMainAcivty(item, HomeBottomNav.this);
                    startActivity(change);
                    return true;
                }
            };
}