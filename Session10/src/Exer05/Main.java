package Exer05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InvoiceManager invoiceManager = new InvoiceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        int currentId = 1;

        while (true) {
            // Hiển thị menu
            System.out.println("\n*************** MENU QUẢN LÝ HÓA ĐƠN ***************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");

            choice = InputData05.getInt(scanner, "Mời bạn nhập lựa chọn: ");

            switch (choice) {
                case 1:
                    String invoiceCode = InputData05.getString(scanner, "Nhập mã hoá đơn");
                    double amount = InputData05.getDouble(scanner, "Mời bạn nhập số tiền: ");
                    Invoice invoice = new Invoice(currentId, invoiceCode, amount);
                    invoiceManager.add(invoice);
                    currentId++;
                    System.out.println("Hoá đơn đã được thêm mới thành công");
                    break;
                case 2:
                    invoiceManager.display();
                    int idUpdate = InputData05.getInt(scanner, "Mời bạn nhập ID cần cập nhật: ");
                    int indexUpdate = invoiceManager.findIndexById(idUpdate);

                    if (indexUpdate == -1) {
                        System.out.println("Không tìm thấy hoá đơn có ID = " + idUpdate);
                    } else {
                        String newInvoiceCode = InputData05.getString(scanner, "Mơi bạn nhập mã hoá đơn mới: ");
                        double newAmount = InputData05.getDouble(scanner, "Mời bạn nhật giá tiền mới: ");
                        invoiceManager.update(indexUpdate, new Invoice(idUpdate, newInvoiceCode, newAmount));
                        System.out.println("Hoá đơn đã được cập nhật thành công.");
                    }
                    break;
                case 3:
                    invoiceManager.display();
                    int idDelete = InputData05.getInt(scanner, "Nhập ID hoá đơn cần xoá: ");
                    int indexDelete = invoiceManager.findIndexById(idDelete);

                    if (indexDelete == -1) {
                        System.out.println("Không tìm thấy ID cần xoá!");
                    } else {
                        invoiceManager.delete(indexDelete);
                        System.out.println("Xoá hoá đơn thành công");
                    }
                    break;
                case 4:
                    System.out.println("Danh sách các hoá đợn: ");
                    invoiceManager.display();
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn bạn nhập không hợp lệ, Vui lòng chọn lại !");
            }
        }
    }
}
