public class Car {
    private String model;
    private String brand;
    private int power;

    public Car(String model, String brand, int power) {
        this.brand = brand;
        this.model = model;
        this.power = power;
    }

    public void getInfo() {
        System.out.printf("The car is: %s %s – %d HP.\n", this.model, this.brand, this.power);
    }
}
