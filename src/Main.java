import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        testCars();
        testBankAccount();
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