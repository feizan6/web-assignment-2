package assignment2.model;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * An entity Item composed of four fields, item, itemName, itemPrice, quantity
 * Created by Fayzan on 13/04/2017.
 */

@Entity
//@Table(name = "items")
public class Item{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 2, max = 30)
    private String itemName;

    @NotNull
    @DecimalMin("0.01")
    private double itemPrice;

    @NotNull
    @Min(1)
    private int quantity;

    public Item(){}

    public Item(String itemName, double itemPrice, int quantity){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setQuantity(int quantity) {
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

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }
}

