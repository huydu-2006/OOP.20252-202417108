import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;
public class BankAccount {
    private long accountNumber;
    private String customerName;
    private double balance;
    private static final double INITIAL_BALANCE = 50_000;
    private static long numsCustomerCount = 0;
    private static final double TRANSFER_FEE = 0.02;
    private static final List<Long> customerIdList = new ArrayList<>();

    public BankAccount() {
        this.balance = BankAccount.INITIAL_BALANCE;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your full name : ");
        this.customerName = sc.nextLine();
        this.accountNumber = BankAccount.numsCustomerCount++;
        BankAccount.customerIdList.add(getHashCode(this.accountNumber, this.customerName));
        System.out.println("Done!");
    }

    public BankAccount(String customerName) {
        this.balance = BankAccount.INITIAL_BALANCE;
        this.accountNumber = BankAccount.numsCustomerCount++;
        BankAccount.customerIdList.add(getHashCode(this.accountNumber, this.customerName));
        System.out.println("Done!");
    }
    public boolean deposite(double amount, long customerID, String customerName) {
        if (!isOwner(customerID, customerName)) {
            return false;
        }
        else if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }
        
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount, long customerID, String customerName) {
        if (!isOwner(customerID, customerName)) {
            return false;
        }
        else if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }
        else if (this.balance - amount < BankAccount.INITIAL_BALANCE) {
            System.out.println("Insufficient balance");
            return false;
        }

        this.balance -= amount;
        return true;
    }

    public boolean transfer(double amount, long receiveAccountNumber, long customerID, String customerName) {
        return true;
    }

    public boolean payBill(double amount, String billName, long customerID, String customerName) {
        return true;
    }

    public double checkBalance(long customerID, String customerName) {
        if (!isOwner(customerID, customerName)) {
            System.out.println("Invalid user");
            return -1D;
        }

        return this.balance;
    }

    public static boolean isOwner(long customerID, String customerName) {
        if (customerID >= BankAccount.numsCustomerCount) {
            System.out.println("Invalid user");
            return false;
        }
        else if (BankAccount.get(customerID) != getHashCode(customerID, customerName)) {
            System.out.println("Invalid user");
            return false;
        }

        return true;
    }

    public static long getHashCode(long customerID, String customerName) {
        final long p = 53, m = (long)Math.pow(10, 9) + 9;
        long hashValue = 0, p_pow = 1;

        for (char c : customerName.toCharArray()) {
            hashValue = (hashValue + c * p_pow) % m;
            p_pow = (p_pow * p) % m;
        }

        return ((hashValue % m) * p * (customerID % m)) % m;
    }
}
