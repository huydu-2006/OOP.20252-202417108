public class Main {
    public static void main(String[] args) {
        BankAccount user1 = new BankAccount();
        BankAccount user2 = new BankAccount();

        String user1ID = user1.getAccountNumber();
        String user2ID = user2.getAccountNumber();
        String user1CustomerName = user1.getCustomerName();
        String user2CustomerName = user2.getCustomerName();

        // test deposite
        user1.deposite(500_000, user1ID, user1CustomerName);
//        user1.deposite(10_000, user2ID, user2CustomerName);
//        user1.deposite(-1, user1ID, user1CustomerName);
//        user1.deposite(20_000, user2ID, user1CustomerName);
        // test withdraw
        user1.withdraw(100_000, user1ID, user1CustomerName);
        System.out.println(user1CustomerName + " balance is : " + user1.checkBalance(user1ID, user1CustomerName));
//        user1.withdraw(-1, user1ID, user1CustomerName);
//        user1.withdraw(100_000, user2ID, user2CustomerName);
//        user1.withdraw(100_000, user1ID, user2CustomerName);
//        user1.withdraw(500_000, user1ID, user1CustomerName);
//        user1.withdraw(450_000, user1ID, user1CustomerName);
        // test transfer
        user1.transfer(100_000, user2, user1ID, user1CustomerName);
        System.out.println(user1CustomerName + " balance is : " + user1.checkBalance(user1ID, user1CustomerName));
        System.out.println(user2CustomerName + " balance is : " + user2.checkBalance(user2ID, user2CustomerName));
//        user1.transfer(100_000, user2, user2ID, user1CustomerName);
//        user1.transfer(348_000, user2, user1ID, user1CustomerName);
        // test pay bill
        user1.payBill(100_000, "electricity", user1ID, user1CustomerName);
        System.out.println(user1CustomerName + " balance is : " + user1.checkBalance(user1ID, user1CustomerName));
//        user1.payBill(248_000, "electricity", user2ID, user2CustomerName);
//        user1.payBill(10_000, "shopping", user1ID, user2CustomerName);

        // print final result
        System.out.println(user1CustomerName + " balance is : " + user1.checkBalance(user1ID, user1CustomerName));
        System.out.println(user2CustomerName + " balance is : " + user2.checkBalance(user2ID, user2CustomerName));
    }
}
