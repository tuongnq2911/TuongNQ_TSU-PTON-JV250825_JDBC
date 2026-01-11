package Exer02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (true) {
            System.out.println("\n************** MENU QUẢN LÝ SÁCH ***************");
            System.out.println("1. Thêm sách");
            System.out.println("2. Tìm kiếm sách");
            System.out.println("3. Hiển thị danh sách sách");
            System.out.println("4. Thoát");
            try {
                choice = InputData02.getInt(scanner, "Lựa chọn của bạn: ");

                switch (choice) {
                    case 1:
                        String title = InputData02.getString(scanner, "Nhập tên sách: ");
                        String author = InputData02.getString(scanner, "Nhập tên tác giả: ");
                        String yearPublished = InputData02.getString(scanner, "Nhập năm xuất bản: ");
                        Book book = new Book(title, author, yearPublished);
                        bookManager.addBook(book);
                        System.out.println("Thêm mới sách đã thành công");
                        break;
                    case 2:
                        System.out.println("Nhập tên sách cần tìm: ");
                        String searchTitle = scanner.nextLine();
                        try {
                            Book foundBook = bookManager.findBook(searchTitle);
                            System.out.println("Tìm thấy sách có tên là: " + foundBook);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("\nDanh sách sách: ");
                        bookManager.displayAllBooks();
                        break;
                    case 4:
                        System.out.println("Thoát chương trình");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Lựa chọn của bạn không phù hợp! Vui lòng chọn lại");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập lựa chọn, vui lòng nhập lựa chọn hợp lệ theo danh sách.");
            }
        }
    }
}
