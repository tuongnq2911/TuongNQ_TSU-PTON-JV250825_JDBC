import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập một số nguyên dương N
        System.out.print("Nhập một số nguyên dương N: ");
        int N = scanner.nextInt();

        // Kiểm tra tính hợp lệ của N
        if (N <= 0) {
            System.out.println("Số nhập vào không hợp lệ.");
        } else {
            // Khai báo biến để lưu trữ tổng
            int sum = 0;

            // Sử dụng vòng lặp for để tính tổng
            for (int i = 1; i <= N; i++) {
                sum += i; // Cộng dồn từng giá trị từ 1 đến N
            }

            // Hiển thị kết quả
            System.out.printf("Tổng các số từ 1 đến %d là: %d%n", N, sum);
        }
    }
}