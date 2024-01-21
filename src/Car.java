public class Car {
    private String model = "unknown";
    private String brand = "unknown";
    private int power = -1;

    public Car(String model) {
        this.model = model;
    }

    public Car(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public Car(String model, String brand, int power) {
        this.brand = brand;
        this.model = model;
        this.power = power;
    }

    public void getInfo() {
        System.out.printf("The car is: %s %s – %d HP.\n", this.model, this.brand, this.power);
    }
}
