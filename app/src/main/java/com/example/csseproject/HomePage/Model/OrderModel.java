package com.example.csseproject.HomePage.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderModel {
    String siteName;
    Date createdDate;
    List<OrderCardTableModel> table_list;

    public OrderModel(String siteName, Date createdDate) {
        this.siteName = siteName;
        this.createdDate = createdDate;
    }

    public OrderModel(String siteName, Date createdDate, List<OrderCardTableModel> table_list) {
        this.siteName = siteName;
        this.createdDate = createdDate;
        this.table_list = table_list;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<OrderCardTableModel> getTable_list() {
        return table_list;
    }

    public void setTable_list(ArrayList<OrderCardTableModel> table_list) {
        this.table_list = table_list;
    }
}