package com.example.csseproject.HomePage.Model;

public class OrderCardModel {
    String Item;
    String Types;
    String Quantity;

    public OrderCardModel(String item, String types, String quantity) {
        Item = item;
        Types = types;
        Quantity = quantity;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getTypes() {
        return Types;
    }

    public void setTypes(String types) {
        Types = types;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
