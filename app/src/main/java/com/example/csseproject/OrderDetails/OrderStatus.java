package com.example.csseproject.OrderDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.csseproject.HomePage.Util.DrawableHelper;
import com.example.csseproject.R;

public class OrderStatus extends AppCompatActivity {

    ImageView settings_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        settings_icon = findViewById(R.id.settings_icon);
        DrawableHelper
                .withContext(this)
                .withColor(R.color.white)
                .withDrawable(R.drawable.outline_settings_24)
                .tint()
                .applyTo(settings_icon);

    }
}