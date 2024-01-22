package Storage;

import netscape.javascript.JSObject;

import java.util.ArrayList;

public class Storage {
    private int capacity;
    private double totalValue = 0;
    private int originalCapacity = 0;
    private ArrayList<Product> inventory;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.originalCapacity = capacity;
        this.inventory = new ArrayList<Product>(1);
    }

    public void addProduct(Product product) {
        if (this.capacity < product.quantity) {
            System.out.println("Not enough space in storage");
            return;
        }

        this.capacity -= product.quantity;
        totalValue += product.quantity * product.price;
        inventory.add(product);
    }

    public void getProducts() {
        this.inventory.forEach(Product::getString);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public double getTotalCost() {
        return this.totalValue;
    }
}
