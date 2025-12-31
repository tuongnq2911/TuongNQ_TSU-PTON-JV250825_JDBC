package Exer04;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo tài khoản A và B
        BankAccount accountA = new BankAccount("A001", "Nguyễn Văn A", "0123456789");
        BankAccount accountB = new BankAccount("B001", "Nguyên Văn B", "0987654321");

        // Nạp tiền vào tài khoản
        accountA.deposit(1000);

        // Chuyển tiền từ tài khoản A đến tài khoản B
        double transferAmount = 300;
        accountA.withdraw(transferAmount); // Rút tiêền từ tài khoản A
        accountB.deposit(transferAmount);  // Nạp tiền vào tài khoản B

        // Hiển thị số dư tk
        accountA.displayBalance();
        accountB.displayBalance();
    }
}
