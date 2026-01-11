package Exer06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n*************** MENU QUẢN LÝ ĐƠN HÀNG ***************");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");

            try {
                choice = InputData06.getInt(scanner, "Mời nhập lựa chọn của ban: ");

                switch (choice) {
                    case 1:
                        String orderId = InputData06.getString(scanner, "Mời bạn nhập mã đơn hàng: ");
                        String customerName = InputData06.getString(scanner, "Mời bạn nhập tên khác hàng: ");
                        Order order = new Order(orderId, customerName);
                        orderManager.add(order);
                        System.out.println("Thêm đơn hàng thành công!");
                        break;
                    case 2:
                        orderManager.display();
                        String orderIdUpdate = InputData06.getString(scanner, "Mời bạn nhập OrderID cần cập nhật: ");
                        int indexUpdate = orderManager.findIndexByOrderId(orderIdUpdate);
                        if (indexUpdate == -1) {
                            System.out.println("Không tìm thấy đơn hàng nào có mã = " + orderIdUpdate);
                        } else {
                            String newCustomerName = InputData06.getString(scanner, "Mời bạn nhập tên khách hàng mới: ");
                            orderManager.update(indexUpdate, new Order(orderIdUpdate, newCustomerName));
                            System.out.println("Đơn hàng đã được cập nhật thành công!");
                        }
                        break;
                    case 3:
                        orderManager.display();
                        String orderIdDelete = InputData06.getString(scanner, "Mời bạn nhập OrderID cần xoá: ");
                        int indexDelete = orderManager.findIndexByOrderId(orderIdDelete);
                        if (indexDelete == -1) {
                            System.out.println("Không tìm thấy đơn hàng nào có mã = " + orderIdDelete);
                        } else {
                            orderManager.delete(indexDelete);
                            System.out.println("Xoá thành công đơn hàng");
                        }
                        break;
                    case 4:
                        System.out.println("Danh sách đơn hàng: ");
                        orderManager.display();
                        break;
                    case 5:
                        System.out.println("Thoát chương trình!");
                        scanner.close();
                        return;
                    default:
                        System.out.println(" Lựa chọn không hợp lệ! Vui lòng chọn lại");

                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số đối với lựa chọn ở Manu!");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
