package ra.presentation;

import ra.entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private static ArrayList<Student> listStudents = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        do {
            System.out.println("\n*********************QUẢN LÝ SINH VIÊN********************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã Sinh Viên");
            System.out.println("4. Xoá sinh viên theo mã Sinh Viên");
            System.out.println("5. Tìm sinh viên theo tên Sinh Viên");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bản: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    displayListStudent();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    findStudentByName();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while(true);
    }

    // 1 Hiển thị danh sách sinh viên
    private static void displayListStudent(){
        if(listStudents.isEmpty()){
            System.out.println("Danh sách sinh viên trống, hãy nhập thông tin sinh viên trước");
            return;
        }
        System.out.println("---DANH SÁCH SINH VIÊN---");
        for(Student student : listStudents){
            student.displayData();
        }
    }

    // 2 Thêm sinh viên
    private static void addStudent(){
        System.out.println("Nhập số lượng sinh viên muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            Student student = new Student();
            student.inputData(scanner);
            listStudents.add(student);
        }
    }

    // 3 Cập nhật sinh viên theo mã SV
    private static void updateStudent(){
        System.out.println("Nhập mã Sinh Viên cần cập nhật: ");
        String idUpdate = scanner.nextLine();
        int index = findIndexById(idUpdate);
        if(index >= 0){
            System.out.println("Nhập thông tin mới: ");
            listStudents.get(index).inputData(scanner);
            System.out.println("Cập nhật thành công");
        }
        else {
            System.err.println("Mã sinh viên không tồn tại");
        }
    }

    // 4 Xoá sinh viên
    private static void deleteStudent(){
        System.out.println("Nhập mã sinh viên cần xoá: ");
        String idDelete = scanner.nextLine();
        int index = findIndexById(idDelete);
        if(index >= 0){
            listStudents.remove(index);
            System.out.println("Xoá thành công!");
        }
        else {
            System.err.println("Mã sinh viên không tồn tại");
        }
    }

    // 5 Tìm kiếm theo tên
    private static void findStudentByName(){
        System.out.println("Nhập tên sinh viên cần tìm");
        String searchName = scanner.nextLine().toLowerCase();
        int count = 0;
        System.out.println("---KẾT QUẢ TÌM KIẾM---");
        for(Student student : listStudents){
            if (student.getStudentName().toLowerCase().contains(searchName)){
                student.displayData();
                count++;
            }
        }
        System.out.println("Tổng số lượng sinh viên tìm thấy: " + count);
    }

    // Hàm phụ trợ tìm vị trí theo ID
    private static int findIndexById(String id){
        for(int i = 0; i < listStudents.size(); i++){
            if(listStudents.get(i).getStudentId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
