package com.example.csseproject.HomePage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csseproject.HomePage.Model.OrderCardTableModel;
import com.example.csseproject.R;

import java.util.List;

public class OrderCardAdapter extends RecyclerView.Adapter<OrderCardAdapter.ViewHolder>{
    Context context;
    List<OrderCardTableModel> item_list;

    public OrderCardAdapter(Context context, List<OrderCardTableModel> order_list) {
        this.context = context;
        this.item_list = order_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  OrderCardAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
