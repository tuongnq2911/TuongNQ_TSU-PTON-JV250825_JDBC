package Exer04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Product> productMap = new HashMap<>();
    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n--- Product Management System ---");
            System.out.println("1. Thêm mới sản phẩm ");
            System.out.println("2. Sửa sản phẩm ");
            System.out.println("3. Xoá sản phẩm ");
            System.out.println("4. Hiển thị sản phẩm ");
            System.out.println("5. Lọc sản phẩm có (Price > 100)");
            System.out.println("6. Tổng giá trị sản phẩm");
            System.out.println("0. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:addProduct();break;
                case 2:editProduct();break;
                case 3:deleteProduct();break;
                case 4:displayProducts();break;
                case 5:filterProducts();break;
                case 6:displayProducts();break;
                case 0:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không phù hợp vui lòng chọn lại");

            }
        }while (choice != 0);
    }
    // Chức năng thêm mới sản phẩm
    private static void addProduct() {
        System.out.println("Nhập vào mã sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập tên saản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        productMap.put(id, new Product(id, name, price));
        System.out.println(" Thêm sản phẩm mới thành công");
    }

    //Chức năng sửa sản phẩm
    private static void editProduct() {
        System.out.println("Vui lòng nhập ID muốn sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (productMap.containsKey(id)) {
            System.out.println("Nhập tên sản phẩm mới: ");
            String name = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm mơi: ");
            double price = Double.parseDouble(scanner.nextLine());
            productMap.put(id, new Product(id, name, price));
            System.out.println("Đã cập nhật sản phẩm mới thành công!");
        }
    }

    //Chức năng xoá sản phẩm
    public static void deleteProduct() {
        System.out.println("Mời bạn nhập vào ID muốn xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (productMap.remove(id) != null) {
            productMap.remove(id);
            System.out.println(" Xoá sản phẩm thành công");
        }else {
            System.out.println("Sản phẩm không tồn tại.");
        }
    }

    // Chức năng hiển thị sản phẩm
    public static void displayProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Danh sách không có sản phẩm");
        }else {
            productMap.values().forEach(System.out::println);
        }
    }

    // Chức năng lọc sản phẩm theo giá
    public static void filterProducts() {
        System.out.println("Nhập sản phẩm có giá trên 100");
        productMap.values().stream().filter(product -> product.getPrice() > 100).forEach(System.out::println);
    }

    //Chức năng tình tổng
    private static void totalValueOfProducts() {
        double total = productMap.values().stream().mapToDouble(Product::getPrice).sum();
        System.out.println("Tổng giá trị của sản phẩm là: " + total);
    }
}
