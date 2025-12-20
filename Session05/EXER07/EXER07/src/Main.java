import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.println("Nhập độ dài chuỗi n trong khoảng 1-1000 mà bạn muốn tạo:");
        int n = 0;
        if(sc.hasNextInt()){
            n = sc.nextInt();
            if(n<1 || n>1000){
                System.out.println("Số " + n + "bạn nhập vào không nằm trong khoảng từ 1-1000");
            }else {
                String result = generateRandomString(n);
                System.out.println("Chuỗi tạo ngẫu nhiên có" + n + "ký tự là:  " + result);
            }
        }else {
            System.out.println("Bạn phải nhập số nguyên mới hợp lệ");
        }
    }
    public static String generateRandomString(int n){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789" ;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < n; i++){
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}