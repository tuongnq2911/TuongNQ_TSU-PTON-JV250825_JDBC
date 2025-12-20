import java.util.Scanner;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.println("Nhap Email: ");
        String input = sc.nextLine();
        if (isEmailValid(input)) {
            System.out.println("Nhap Email Is Valid");
        }else {
            System.out.println("Nhap Email Is Invalid");
        }
    }
    public static  boolean isEmailValid(String email) {
        final String regex = "\\w+@\\w+\\.\\w+$";
        return Pattern.matches(regex, email);
    }
}