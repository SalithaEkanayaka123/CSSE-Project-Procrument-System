package lk.csse.procurement.backend.model;

import javax.persistence.*;


@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "itemId")
    private int itemId;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "description")
    private String description;
    @Column(name = "qty")
    private int qty;
    @Column(name = "price")
    private double price;

    public Item() {

    }

    public Item(int itemId, String itemName, String description, int qty, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.qty = qty;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
