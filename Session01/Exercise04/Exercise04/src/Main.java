//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Khai báo và khởi tạo hai biến số nguyên
        int a = 15; // Thay đổi giá trị nếu cần
        int b = 10;  // Thay đổi giá trị nếu cần

        // Thực hiện các phép toán
        int sum = a + b;          // Tính tổng
        int difference = a - b;   // Tính hiệu
        int product = a * b;      // Tính tích
        int quotient = a / b;     // Tính thương
        int remainder = a % b;    // Tính phần dư

        // In kết quả ra màn hình
        System.out.printf("Giá trị a: %d%n", a);
        System.out.printf("Giá trị b: %d%n", b);
        System.out.printf("Tổng của a và b: %d%n", sum);
        System.out.printf("Hiệu của a và b: %d%n", difference);
        System.out.printf("Tích của a và b: %d%n", product);
        System.out.printf("Thương của a chia cho b: %d%n", quotient);
        System.out.printf("Phần dư khi chia a cho b: %d%n", remainder);
    }
}