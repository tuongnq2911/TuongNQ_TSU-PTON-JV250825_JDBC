package Exer06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Chọn chức năng");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Xoá sách");
            System.out.println("4. Thoát");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    // Chọn chức năng
                    System.out.println("Nhập tiêu đề: ");
                    String title = scanner.nextLine();
                    System.out.println("Nhập tên tác giả: ");
                    String author = scanner.nextLine();
                    System.out.println("Nhập ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.println("Nhập năm xuất bản: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    bookManager.addBook(new Book(title, author, isbn, year));
                    break;
                case 2:
                    bookManager.displayBooks();
                case 3:
                    System.out.println("Nhập ISBN sách cần xoá: ");
                    String isbnToRemove = scanner.nextLine();
                    bookManager.removeBook(isbnToRemove);
                    break;
                case 4:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không hợp lệ. Vui lòng chọn lại.");

            }
        }while (choice != 4);
        scanner.close();
    }
}
