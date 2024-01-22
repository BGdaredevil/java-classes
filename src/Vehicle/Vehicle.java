package Vehicle;

public class Vehicle {
    public  String type = "unknown";
    public  String model = "unknown";
    public Engine engine;
    public int fuel = 0;

    public Vehicle(String type, String model, Engine engine, int fuel) {
        this.type = type;
        this.model = model;
        this.engine = engine;
        this.fuel = fuel;
    }

    public  void drive(int qty) {
        this.fuel -= qty;
    };

    public static void getInfo(Vehicle car) {
        System.out.printf("The car is %s %s with %d hp engine and has %d fuel left.\n", car.type, car.model, car.engine.power, car.fuel );
    }
}

