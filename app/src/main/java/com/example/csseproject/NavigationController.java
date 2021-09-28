package com.example.csseproject;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.example.csseproject.HomePage.HomePage;
import com.example.csseproject.HomePage.OrderForm;
import com.example.csseproject.OrderDetails.OrderStatus;
import com.example.csseproject.ProfileView.ProfilePage;

public class NavigationController {
    public Intent ChangeMainAcivty(MenuItem item, Context currentIntent) {
        switch (item.getItemId()){
            case R.id.nav_home :
                Intent intent = new Intent(currentIntent, HomePage.class);
                return intent;
            case R.id.nav_add :
                Intent intent1 = new Intent(currentIntent, OrderStatus.class);
                return intent1;
            case R.id.nav_user :
                Intent intent2 = new Intent(currentIntent, ProfilePage.class);
                return intent2;
        }
        return null;
    }
}
