import Storage.Product;
import Storage.Storage;
import Vehicle.Engine;
import Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        testCars();
//        testBankAccount();
//        testVehicle();
//        testStorage();
//        testRandomizer();
//        testStudents();


    }

    private static void testStudents() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<Student>();
        System.out.println("get comand");
        String comand = sc.nextLine();

        while (!comand.equals("end")) {
            String[] studentData = comand.split(" ");
            students.add(new Student(studentData[0], studentData[1], Integer.parseInt(studentData[2]), studentData[3]));

            System.out.println("get comand");
            comand = sc.nextLine();
        }

        System.out.println("get comand");
        String city = sc.nextLine();

        students.stream().filter(student -> student.getCity().equals(city)).forEach(student -> System.out.println(student.getInfo()));


    }

    private static void testRandomizer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("get line");
        String[] input = sc.nextLine().split(" ");

        Random randNum = new Random();

        for (int i = 0; i < input.length; i++) {
            String temp = input[i];
            int randIndex = randNum.nextInt(input.length);
            input[i] = input[randIndex];
            input[randIndex] = temp;
        }

        for (String row : input) {
            System.out.println(row);
        }

    }

    private static void testStorage() {
        Product product1 = new Product("cucumber", 1.50, 15);
        Product product2 = new Product("tomato", 0.90, 25);
        Product product3 = new Product("bread", 1.10, 8);

        Storage sklad = new Storage(50);

        sklad.addProduct(product1);
        sklad.addProduct(product2);
        sklad.addProduct(product3);

        sklad.getProducts();
        System.out.println(sklad.getCapacity());
        System.out.println(sklad.getTotalCost());
    }

    private static void testVehicle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("awaiting command");
        String[] command = sc.nextLine().split(" - ");
        String[] comandParams = command[1].split(": ");

        if (command[0].equals("Engine")) {
            Engine eng = new Engine(Integer.parseInt(comandParams[1]));
            Vehicle car = new Vehicle("unknown", "unknown", eng, 200);
            car.drive(100);

            Vehicle.getInfo(car);
        }

    }

    private static void testBankAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("awaiting command");
        String command = sc.nextLine();

        while (!command.equals("End")) {
            String[] comandParams = command.split(" ");
            String action = comandParams[0];

            switch (action) {
                case "Create": {
                    new BankAccount();
                    break;
                }

                case "Deposit": {
                    int instanceId = Integer.parseInt(comandParams[1]);
                    double qty = Double.parseDouble(comandParams[2]);

                    Optional<BankAccount> account = BankAccount.getAccountById(instanceId);

                    if (account.isPresent()) {
                        account.get().deposit(qty);
                        System.out.printf("Deposited %.0f to ID%d\n", qty, instanceId);
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;
                }

                case "SetInterest": {
                    BankAccount.setInterestRate(Double.parseDouble(comandParams[1]));

                    break;
                }

                case "GetInterest": {
                    int instanceId = Integer.parseInt(comandParams[1]);
                    int years = Integer.parseInt(comandParams[2]);
                    Optional<BankAccount> account = BankAccount.getAccountById(instanceId);

                    if (account.isPresent()) {
                        double interest = account.get().getInterest(years);
                        System.out.printf("%.2f\n", interest);
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;
                }
            }
            System.out.println("awaiting command");

            command = sc.nextLine();
        }

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