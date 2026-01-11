package Exer07;

import Exer06.InputData06;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên (Cần ít nhất 5)");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo tên");
            System.out.println("4. Phân loại và hiển thị theo GPA");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        inputStudent();
                        break;
                    case 2:
                        displayStudentList();
                        break;
                    case 3:
                        searchByName();
                        break;
                    case 4:
                        displayClassification();
                        break;
                    case 5:
                        System.out.println("Kết thúc chương trình");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Vui lòng lựa chọn từ 1-5");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập lựa chọn số cho Menu!");
            }
        }
    }

    private static void inputStudent() {
        System.out.println("Nhập số lượng sinh viên muốn thêm vào: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine());
            if (n < 5 && studentList.size() + n < 5) {
                System.out.println("Bạn cần nhập tổng cộng ít nhất 5 sinh viên");
            }
        } catch (NumberFormatException e) {
            System.out.println("Số lượng không hợp lệ");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sinh viên thứ " + (studentList.size() + 1) + ": ");
            try {
                System.out.print("ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Họ Tên: ");
                String name = scanner.nextLine();
                System.out.println("Điểm trung bình: ");
                double gpa = Double.parseDouble(scanner.nextLine());

                if (gpa < 0 || gpa > 10) {
                    System.out.println("Điểm trung bình phải nằm trong khoảng từ 0 - 10!");
                    i--;// Nhập lại thông tin của sinh viên vừa nhập sai
                    continue;
                }
                studentList.add(new Student(id, name, gpa));
            } catch (NumberFormatException e) {
                System.out.println("ID phải là s nguyên và Điểm trung bình phải là số thực. Vui lòng nhập lại!");
                i--;
            }
        }
    }

    // Chức năng 2: Hiển thị
    private static void displayStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách chưa có sinh viên!");
            return;
        }
        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    // Chức năng 3: Tìm kiếm theo tên
    private static void searchByName() {
        System.out.println("Nhập tên sinh viên cần tìm: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thây sinh viên nào có tên: " + searchName);
        }
    }

    // Chức năng 4: Phân loại điêểm trung bình
    private static void displayClassification() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách chưa có thông tin sinh viên!");
            return;
        }
        System.out.println("\n--- PHÂN LOẠI SINH VIÊN THEO GPA ---");
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }
}
