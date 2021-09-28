package com.example.csseproject.HomePage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csseproject.HomePage.Model.OrderCardTableModel;
import com.example.csseproject.R;

import java.util.List;

public class OrderCardTableAdapter extends RecyclerView.Adapter<OrderCardTableAdapter.ViewHolder> {
    Context context;
    List<OrderCardTableModel> item_list;

    public OrderCardTableAdapter(Context context, List<OrderCardTableModel> item_list){
        this.context = context;
        this.item_list = item_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  OrderCardTableAdapter.ViewHolder holder, int position) {
        if(item_list != null && item_list.size() > 0){
            OrderCardTableModel model = item_list.get(position);
            holder.item_column_data.setText(model.getItem());
            holder.types_column_data.setText(model.getTypes());
            holder.quantity_column_data.setText(model.getQuantity());
        }
    }

    @Override
    public int getItemCount() {
        return item_list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_column_data;
        TextView types_column_data;
        TextView quantity_column_data;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            item_column_data = itemView.findViewById(R.id.item_column_data);
            types_column_data = itemView.findViewById(R.id.types_column_data);
            quantity_column_data = itemView.findViewById(R.id.quantity_column_data);
        }
    }
}
