package assignment2;

/**
 * Created by Fayzan on 13/04/2017.
 */
public class Item {
    private String itemName;
    private int quantity;
    private double itemPrice;

    public Item(){}

    public Item(String itemName, int quantity, double itemPrice){
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getTotalPrice() {
        return itemPrice * quantity;
    }
}
