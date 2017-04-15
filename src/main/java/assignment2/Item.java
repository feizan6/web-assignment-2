package assignment2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Fayzan on 13/04/2017.
 */

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String itemName;
    private double itemPrice;
    private int quantity;

    public Item(){}

    public Item(String itemName, double itemPrice, int quantity){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getTotalPrice(){
        return itemPrice * quantity;
    }

    public Integer getId() {
        return id;
    }
}

