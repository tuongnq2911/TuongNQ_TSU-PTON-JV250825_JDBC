package Exer04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttendanceManager attendanceManager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // Hiển thị menu
            System.out.println("\n*************** MENU QUẢN LÝ ĐIỂM DANH ***************");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thoát");

            choice = InputData04.getInt(scanner, "Nhập lựa chọn của bạn: ");
            switch (choice) {
                case 1:
                    int studentID = InputData04.getInt(scanner, "Nhập vào mã sinh viên: ");
                    String studentName = InputData04.getString(scanner, "Nhập vào tên sinh viên: ");
                    Student student = new Student(studentID, studentName);
                    attendanceManager.add(student);
                    System.out.println("Thêm mới sinh viên thành công");
                    break;
                case 2:
                    attendanceManager.display();
                    int idStudent = InputData04.getInt(scanner, "Nhập vào ID sinh viên cần sửa: ");
                    int index = -1;
                    for (int i = 0; i < attendanceManager.students.size(); i++) {
                        if (attendanceManager.students.get(i).getStudentID() == idStudent) {
                            index = i;
                            break;
                        }
                    }
                    if (index == -1) {
                        System.out.println("Không tìm thấy sinh viên cần sửa!");
                    } else {
                        String newStudentName = InputData04.getString(scanner, "Nhập tên sinh viên mới: ");
                        attendanceManager.update(index, new Student(idStudent, newStudentName));
                        System.out.println("Sinh viên đươợc cập nhật thành công!");
                    }
                    break;
                case 3:
                    attendanceManager.display();
                    int idDelete = InputData04.getInt(scanner, "Nhập ID sinh viên cần xoá: ");
                    int indexDelete = -1;
                    for (int i = 0; i < attendanceManager.students.size(); i++) {
                        if (attendanceManager.students.get(i).getStudentID() == idDelete) {
                            indexDelete = i;
                            break;
                        }
                    }
                    if (indexDelete == -1) {
                        System.out.println("Không tìm thấy ID sinh viên cần xoá!");
                    } else {
                        attendanceManager.delete(indexDelete);
                        System.out.println("Xoá thành công sinh viên có ID là: " + idDelete);
                    }
                    break;
                case 4:
                    attendanceManager.display();
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hơp lệ! Vui lòng chọn lại.");
            }
        }
    }
}
