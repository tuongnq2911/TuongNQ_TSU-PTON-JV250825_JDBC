import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào chuỗi có chứa đầy đủ ký tự chữ và số:");
        String inputString = sc.nextLine();
        String replaceAlString = inputString.replaceAll("[0-9]", "*");
        System.out.println("Chuỗi sau khi thay đổi toàn bị ký tự số thành ký tự * là: " + replaceAlString);
        sc.close();
    }
}