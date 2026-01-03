package ra.entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private String major;

    // tạo contructor không tham số
    public Student(){};

    public Student(String studentId, String studentName, int age, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.major = major;
    }

    // Tạo Getter và Setter

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Phương thức nhập liệu
    public void inputData(Scanner scanner){
        System.out.println("Nhập mã Sinh viên");
        this.studentId = scanner.nextLine();
        System.out.println("Nhập tên sinh viên");
        this.studentName = scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chuyên ngành");
        this.major = scanner.nextLine();
    }

    // Phương thức hiển thị dữ liệu
    public void displayData(){
        System.out.printf("Mã SV: %-10s | Tên SV: %-20s | Tuổi: %-5d | Chuyên ngành: %-15s\n", studentId,studentName,age,major);
    }
}
