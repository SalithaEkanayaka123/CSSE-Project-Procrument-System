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
