package Exer03;

public class Main {
    public static void main(String[] args) {
        // Tạo các đối tượng hình học
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(5.0, 6.0);
        Square square = new Square(5.5);

        // Thiết lập màu sắc
        circle.setColor("Red");
        rectangle.setColor("Blue");
        square.setColor("Green");

        // In màu sắc
        System.out.println("Màu hình tròn là: " + circle.getColor());
        System.out.println("Màu hình chữ nhật là: " + rectangle.getColor());
        System.out.println("Màu hình vuông là: " + square.getColor());
    }
}
