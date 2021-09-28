package com.example.csseproject.HomePage.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.csseproject.HomePage.Model.OrderCardTableModel;
import com.example.csseproject.HomePage.Model.OrderModel;
import com.example.csseproject.R;

import java.util.List;

public class OrderCardAdapter extends RecyclerView.Adapter<OrderCardAdapter.ViewHolder>{
    Context context;
    List<OrderModel> item_list;
    List<OrderCardTableModel> tableItemList;

    public OrderCardAdapter(Context context, List<OrderModel> order_list) {
        this.context = context;
        this.item_list = order_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_order_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  OrderCardAdapter.ViewHolder holder, int position) {

        if(item_list != null && item_list.size() > 0){
            OrderModel model = item_list.get(position);
            holder.card_site_name.setText(model.getSiteName());
            holder.card_created_date.setText(model.getCreatedDate().toString());
        }

    }

    @Override
    public int getItemCount() {
        return item_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView card_site_name;
        TextView card_created_date;
        RecyclerView card_recycler_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_site_name = itemView.findViewById(R.id.card_site_name);
            card_created_date = itemView.findViewById(R.id.card_created_date);
            card_recycler_view = itemView.findViewById(R.id.card_recycler_view);
        }
    }

    private void setTableItems(RecyclerView view, List<OrderCardTableModel> tableList){
        this.tableItemList = tableList;
        view.setHasFixedSize(true);
        view.setLayoutManager(new LinearLayoutManager(context));
        OrderCardTableAdapter adapter = new OrderCardTableAdapter(context, tableList);
        view.setAdapter(adapter);
    }
}
