import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập mật khẩu cần kiểm tra tính hợp lệ: ");
        String password = sc.nextLine().trim();
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%!]).{8,}$";
        if (password.matches(passwordRegex)) {
            System.out.println("Mật khẩu bạn nhập hợp lệ");
        }
        else {
            System.out.println("Mật khẩu nhập không đúng định dạng");
        }
        sc.close();
    }
}