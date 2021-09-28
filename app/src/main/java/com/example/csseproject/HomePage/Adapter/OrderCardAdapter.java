package com.example.csseproject.HomePage.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csseproject.HomePage.Model.OrderCardModel;

import java.util.List;

public class OrderCardAdapter extends RecyclerView.Adapter<OrderCardAdapter.ViewHolder> {
    Context context;
    List<OrderCardModel> item_list;

    public OrderCardAdapter (Context context, List<OrderCardModel> item_list){
        this.context = context;
        this.item_list = item_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  OrderCardAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
        }
    }
}
