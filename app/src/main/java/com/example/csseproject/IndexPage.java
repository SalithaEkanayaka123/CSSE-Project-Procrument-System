package com.example.csseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.csseproject.HomeBottomNav.HomeBottomNav;
import com.example.csseproject.HomePage.HomePage;
import com.example.csseproject.HomePage.Model.OrderModel;
import com.example.csseproject.OrderDetails.OrderStatus;
import com.example.csseproject.ProfileView.LoginPage;
import com.example.csseproject.ProfileView.ProfilePage;
import com.example.csseproject.ProfileView.ProfilePageEditting;
import com.example.csseproject.ProfileView.informationSubmissionForm;

public class IndexPage extends AppCompatActivity {

    Button settingButton;
    Button BottomNav;
    Button orderStatus;
    Button informationSubmissionForm1, profile, profileEditing, Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingButton = findViewById(R.id.order_list);
        orderStatus = findViewById(R.id.view_status);
        BottomNav = findViewById(R.id.bottomNav);//informationsubmissionform
        informationSubmissionForm1 = findViewById(R.id.informationsubmissionform);//
        profile = findViewById(R.id.profile);
        profileEditing = findViewById(R.id.profilepageEdit);
        Login = findViewById(R.id.loginPage);

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HomePage.class);
                view.getContext().startActivity(intent);
            }
        });

        orderStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), OrderStatus.class);
                view.getContext().startActivity(intent);
            }
        });

        BottomNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), HomeBottomNav.class);
                view.getContext().startActivity(intent);
            }
        });//

        informationSubmissionForm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), informationSubmissionForm.class);
                view.getContext().startActivity(intent);
            }
        });//informationSubmissionForm

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProfilePage.class);
                view.getContext().startActivity(intent);
            }
        });

        profileEditing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProfilePageEditting.class);
                view.getContext().startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LoginPage.class);
                view.getContext().startActivity(intent);
            }
        });


    }
}