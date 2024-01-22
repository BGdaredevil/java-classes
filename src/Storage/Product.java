package Storage;

public class Product {
    public final String name;
    public final double price;
    public final int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static void getString(Product instance) {
        System.out.printf("{\"name\":\"%s\",\"price\":%f,\"quantity\":%d}\n", instance.name, instance.price, instance.quantity);
    }
}
