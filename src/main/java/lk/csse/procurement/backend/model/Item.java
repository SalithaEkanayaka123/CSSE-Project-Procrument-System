package lk.csse.procurement.backend.model;

public class Item {
    private int itemId;
    private String itemName;
    private String description;
    private int qty;

    public Item() {

    }

    public Item(int itemId, String itemName, String description, int qty) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.qty = qty;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
