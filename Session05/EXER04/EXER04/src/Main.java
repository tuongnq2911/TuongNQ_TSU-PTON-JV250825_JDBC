import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào địa chỉ Email: ");
        String email = sc.nextLine().trim();
        String emailRegex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,6})+$";
        if(email.matches(emailRegex)){
            System.out.println("Email bạn nhập vào hơp lệ");
        }else {
            System.out.println("Email bạn nhập không hợp lệ");
        }
        sc.close();
    }
}