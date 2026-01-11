package Exer03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (true) {

            System.out.println("\n*************** MENU QUẢN LÝ NGƯỜI DÙNG ***************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            try {
                choice = InputData03.getInt(scanner, "Nhập vào lựa chọn của bạn: ");
                switch (choice) {
                    case 1:
                        String name = InputData03.getString(scanner, "Nhập tên người dùng: ");
                        String email = InputData03.getString(scanner, "Nhập email người dùng");
                        String phoneNumber = InputData03.getString(scanner, "Nhập vào số điện thoại người dùng");

                        User user = new User(name, email, phoneNumber);
                        userManager.addUser(user);
                        System.out.println("Thêm mới người dùng thành công!");
                        break;
                    case 2:
                        String emailToDelete = InputData03.getString(scanner, "Nhập email người dùng cần xoá: ");
                        if (userManager.removeUser(emailToDelete)) {
                            System.out.println("Xoá người dùng thành công!");
                        } else {
                            System.out.println("Người dùng có email: " + emailToDelete + " không tồn tại");
                        }
                        break;
                    case 3:
                        System.out.println("\nDanh sách người dùng là: ");
                        userManager.displayAllUsers();
                        break;
                    case 4:
                        System.out.println("Thoát chương trình.");
                        scanner.close();
                        return;
                        default:
                            System.out.println("Lựa chọn của bạn không phù hợp, vui lòng nhập lại!!");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Lỗi nhập liệu từ bàn phím không chính xác, vui lòng nhập số nguyên từ 1 tới 4.");
            }
        }
    }
}
