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

    public boolean deposite(double amount, long customerID, String customerName) {
        return true; // prototype 
    }

    public boolean withdraw(double amount, long customerID, String customerName) {
        return true; // prototype
    }

    public boolean transfer(double amount, long receiveAccountNumber, long customerID, String customerName) {
        return true;
    }

    public boolean payBill(double amount, String billName, long customerID, String customerName) {
        return true;
    }

    public static double checkBalance(long customerID, String customerName) {
        return 1.0; // prototype
    }

    public static boolean isOwner(long customerID, String customerName) {
        return true;
    }

    public static long getHashCode(long customerID, String customerName) {

    }
}
