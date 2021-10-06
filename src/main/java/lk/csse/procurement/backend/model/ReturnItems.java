package lk.csse.procurement.backend.model;

/**
 * Template DB Model Class.
 * **/
public class ReturnItems {

    private int Id;
    private int ItemId;
    private String ItemName;
    private int SupplierId;

    public ReturnItems(int id, int itemId, String itemName, int supplierId) {
        Id = id;
        ItemId = itemId;
        ItemName = itemName;
        SupplierId = supplierId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int supplierId) {
        SupplierId = supplierId;
    }
}
