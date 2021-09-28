package com.example.csseproject.HomePage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import com.example.csseproject.HomePage.Adapter.OrderCardAdapter;
import com.example.csseproject.HomePage.Adapter.OrderCardTableAdapter;
import com.example.csseproject.HomePage.Model.OrderCardTableModel;
import com.example.csseproject.HomePage.Model.OrderModel;
import com.example.csseproject.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomePage extends AppCompatActivity {

    RecyclerView place_order_recycler_view;
    OrderCardAdapter orderCardAdapter;
    ArrayList<OrderModel> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);

        List<OrderCardTableModel> orderTableItems = new ArrayList<>();
        orderTableItems.add(new OrderCardTableModel("Cement","Bags", "30KG"));
        orderTableItems.add(new OrderCardTableModel("Nuts","Pkt", "5 Pkt"));
        orderTableItems.add(new OrderCardTableModel("Brick","Cube", "5 cube"));
        orderTableItems.add(new OrderCardTableModel("Machines","Drill", "x1"));
        orderTableItems.add(new OrderCardTableModel("shovel","Item", "x4"));

        orders = new ArrayList<>();
        orders.add(new OrderModel("Site 1",  new Date(2014, 02, 11), orderTableItems));
        orders.add(new OrderModel("Site 2",  new Date(2014, 02, 11), orderTableItems));
        orders.add(new OrderModel("Site 3",  new Date(2014, 02, 11), orderTableItems));
        orders.add(new OrderModel("Site 4",  new Date(2014, 02, 11), orderTableItems));
        setMainOrderRecycler(orders);
    }

    private void setMainOrderRecycler(List<OrderModel> list){
        place_order_recycler_view = findViewById(R.id.place_order_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        place_order_recycler_view.setLayoutManager(layoutManager);
        orderCardAdapter = new OrderCardAdapter(this, list);
        place_order_recycler_view.setAdapter(orderCardAdapter);
    }
}