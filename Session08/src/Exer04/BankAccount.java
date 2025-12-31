package Exer04;

public class BankAccount implements IBank {
    private String accountID;
    private double balance;
    private String username;
    private String phoneNumber;

    public BankAccount(String accountID, String username, String phoneNumber) {
        this.accountID = accountID;
        this.balance = 0.0;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Đã nhận số tiền: " + amount);
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Đã rút số tiên: " + amount);
        }else {
            System.out.println("Số dư không đủ.");
        }
    }
    public void displayBalance() {
        System.out.println("Số dư tài khoản (" + accountID + ") là: " + balance);
    }
    public String getAccountID() {
        return accountID;
    }
}
