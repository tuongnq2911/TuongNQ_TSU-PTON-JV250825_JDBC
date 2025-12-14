import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
// Tạo đối tượng Scanner để nhập dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập một số nguyên
        System.out.print("Nhập một số nguyên: ");
        int n = scanner.nextInt();

        // Kiểm tra số chẵn lẻ
        if (n == 0) {
            System.out.println("Số không phải chẵn cũng không phải lẻ.");
        } else if (n % 2 == 0) {
            System.out.printf("Số %d là số chẵn.%n", n);
        } else {
            System.out.printf("Số %d là số lẻ.%n", n);
        }

    }
}