package Exer01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        String continueInput;
        do {
            String name = InputData.getString(scanner, "Nhập tên sinh viên: ");
            int age = InputData.getInt(scanner, "Nhập tuổi sinh viên: ");
            double averageScore = InputData.getDouble(scanner, "Vui lòng nhập điêm trung bình của Sinh Viên: ");

            Student student = new Student(name, age, averageScore);
            studentManager.addStudent(student);

            continueInput = InputData.getString(scanner, "Bạn có muốn thêm sinh viên khác? y/n: ");
        }while (continueInput.equalsIgnoreCase("y"));

        System.out.println("\nDanh sách sinh viên: ");
        studentManager.displayAllStudents();
        scanner.close();
    }
}
