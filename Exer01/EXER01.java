package Exer01;

public class EXER01 {
    public static void main(String[] args) {
        // Tạo đối tượng Rectangle với constructor mặc định
        Rectangle rect1 = new Rectangle();
        System.out.println("Hình chữ nhật 1:");
        rect1.display();

        // Tạo đối tượng Rectangle với constructor có tham số
        Rectangle rect2 = new Rectangle(5.0, 3.0);
        System.out.println("\nHình chữ nhật 2:");
        rect2.display();
    }
}
