import java.util.ArrayList;
import java.util.Optional;

public class BankAccount {
    private static int nextId = 1;
    private static ArrayList<BankAccount> instances = new ArrayList<BankAccount>();
    private int id;
    private double balance = 0;
    private static double interestRate = 0.02;

    public BankAccount() {
        this.id = nextId++;

        instances.add(this);
        System.out.printf("Account ID%d created\n", this.id);
    }

    public static Optional<BankAccount> getAccountById(int id) {
       Optional<BankAccount> item = instances.stream().filter(e -> e.id == id).findFirst();

        return item;
    }
    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        double result = (this.balance * BankAccount.interestRate) * years ;

        return result;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
