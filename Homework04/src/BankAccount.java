import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class BankAccount {
    private String accountNumber;
    private String customerName;
    private double balance;
    private final int secretKey;
    private static final double INITIAL_BALANCE = 50_000;
    private static final double TRANSFER_FEE = 0.02;
    private static final Map<String, Boolean> accountNumberList = new HashMap<>();

    public BankAccount() {
        this.balance = BankAccount.INITIAL_BALANCE;
        Scanner sc = new Scanner(System.in);
        int count = 0;
        do {
            if (count != 0) System.out.println("Not a valid name");
            System.out.print("Enter your full name : ");
            this.customerName = sc.nextLine();
            count++;
        } while(this.customerName.trim().isEmpty());
        count = 0;
        do {
            if (count != 0) System.out.println("Not a valid account number");
            System.out.print("Enter your account number (String of 8 numbers) : ");
            this.accountNumber = sc.nextLine();
            count++;
        } while (accountNumberList.containsKey(this.accountNumber) || this.accountNumber.trim().isEmpty() || !this.accountNumber.matches("\\d{8}") );
        count = 0;
        accountNumberList.put(accountNumber, true);
        do {
            if (count != 0) System.out.println("Not a valid balance");
            System.out.print("Enter your balance : ");
            this.balance = sc.nextDouble();
            count++;
        }  while (this.balance < BankAccount.INITIAL_BALANCE);
        this.secretKey = getHashCode(this.accountNumber, this.customerName);
        System.out.println("Done!");
    }

    public boolean deposite(double amount, String customerID, String customerName) {
        if (!isOwner(customerID, customerName, this.secretKey)) {
            return false;
        }
        else if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }
        else if (!this.customerName.equals(customerName) || !this.accountNumber.equals(customerID)) {
            System.out.println("Invalid user");
            return false;
        }
        this.balance += amount;
        System.out.println(customerName + " deposited " + amount);
        return true;
    }

    public boolean withdraw(double amount, String customerID, String customerName) {
        if (!isOwner(customerID, customerName, this.secretKey)) {
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
        else if (!this.customerName.equals(customerName) || !this.accountNumber.equals(customerID)) {
            System.out.println("Invalid user");
            return false;
        }

        this.balance -= amount;
        System.out.println(customerName + " withdrawn " + amount);
        return true;
    }

    public boolean transfer(double amount, BankAccount receiveAccount, String customerID, String customerName) {
        if (!isOwner(customerID, customerName, this.secretKey)) {
            return false;
        }
        else if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }
        else if (!isOwner(receiveAccount.accountNumber, receiveAccount.customerName, receiveAccount.secretKey)) {
            System.out.println("Invalid receiver");
            return false;
        }
        else if (this.balance - amount * (1 + BankAccount.TRANSFER_FEE) < BankAccount.INITIAL_BALANCE) {
            System.out.println("Insufficient balance");
            return false;
        }
        
        this.balance -= amount * (1 + BankAccount.TRANSFER_FEE);
        receiveAccount.balance += amount;
        System.out.println(customerName  + " transferred " + amount + " to " + receiveAccount.customerName);
        return true;
    }

    public boolean payBill(double amount, String billName, String customerID, String customerName) {
        if (billName == null) {
            System.out.println("Invalid bill");
            return false;
        }
        else if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }
        else if (!isOwner(customerID, customerName, this.secretKey)) {
            return false;
        }
        else if (this.balance - amount < BankAccount.INITIAL_BALANCE) {
            System.out.println("Insufficient balance");
            return false;
        }

        this.balance -= amount;
        System.out.println(customerName + " payed " + amount + " to " + billName);
        return true;
    }

    public double checkBalance(String customerID, String customerName) {
        if (!isOwner(customerID, customerName, this.secretKey)) {
            return -1D;
        }
        return this.balance;
    }

    public static boolean isOwner(String customerID, String customerName, int customerSecretKey) {
        if (customerSecretKey != BankAccount.getHashCode(customerID, customerName)) {
            System.out.println("Invalid user");
            return false;
        }
        return true;
    }

    public static int getHashCode(String customerID, String customerName) {
        final int p = 53, m = 1103;
        int hashValue = 0, p_pow = 1;
        int customerIDInt = Integer.parseInt(customerID) % m;

        for (char c : customerName.toCharArray()) {
            hashValue = (hashValue + (c * (p_pow) % m) % m) % m;
            p_pow = (p_pow * p) % m;
        }

        return (((hashValue % m) * p) % m * ((customerIDInt + 1) % m)) % m;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }
}
