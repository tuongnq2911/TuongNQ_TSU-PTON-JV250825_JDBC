import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentCount = 0;
        double totalPoint = 0;
        double min = 11;
        double max = -1;
    do {
        System.out.println("***************MENU NHẬP ĐIỂM***************");
        System.out.println("1.Nhập điểm học viên");
        System.out.println("2.Hiển thị thống kê");
        System.out.println("3.Thoát");

        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Moi ban nhap diem tu (0-10): ");
                double point = Double.parseDouble(sc.nextLine());
                if (point >= 0 && point <= 10) {
                    if (point < 5) System.out.println("Học lực: Yếu");
                    else if (point < 7) System.out.println("Học lực: Trung Bình");
                    else if (point < 8) System.out.println("Học lực: Khá");
                    else if (point < 9) System.out.println("Học lực: Giỏi");
                    else System.out.println("Học lực: Xuất Sắc");

                    // Cập nhật thống kê
                    studentCount++;
                    totalPoint += point;
                    if (point < min) min = point;
                    if (point > max) max = point;
                }else if (point == -1) {
                    break;
                }else {
                    System.err.println("Điểm không hợp lệ (phải từ 0 - 10)!");
                }
                break;
                case 2:
                if(studentCount == 0) {
                    System.out.println("Chua co hoc vien nao");
                }else {
                    System.out.println("So hoc vien da nhap " + studentCount);
                    System.out.printf("diem trung binh %.2f" ,totalPoint/studentCount);
                    System.out.println("Diem cao nhat" + max);
                    System.out.println("Diem thap nhat" + min);
                }
                break;
                case 3:
                    System.out.println("Cam on ban da su dung phan mem!");
                    System.exit(0);
        }
    }while (true);
    }
}