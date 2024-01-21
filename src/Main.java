import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        testCars();
    }

    private static void testCars() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get car count");

        int carCount = Integer.parseInt(sc.nextLine());
        ArrayList<Car> carList = new ArrayList<Car>(carCount);

        for (int i = 0; i < carCount; i++) {
            System.out.println("get car data");
            String[] carData = sc.nextLine().split(" ");

            if (carData.length == 1) {
                carList.add(new Car(carData[0]));
            }

            if (carData.length == 2) {
                carList.add(new Car(carData[0], carData[1]));
            }

            if (carData.length == 3) {
                carList.add(new Car(carData[0], carData[1], Integer.parseInt(carData[2])));
            }

        }

        carList.forEach(Car::getInfo);
    }
}