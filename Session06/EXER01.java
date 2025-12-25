package Session06;

import java.util.Scanner;

public class EXER01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] points = new double[100];
        int n = 0;
        while(true) {
            System.out.println("\n******************QUẢN LÝ ĐIỂM SV****************");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình của các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng sinh viên giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.println("Mời bạn nhập lựa chọn từ 1-8");
            int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Vui lòng nhập số lượng học sinh trong lớp: ");
                n = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < n; i++) {
                    System.out.println("Điểm sinh viên thứ " + (i+1));
                    points[i] = Double.parseDouble(sc.nextLine());
                }
                break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập vào sinh viên thứ "+ (i+1) + " điểm " + points[i]);
                    }
                    break;
            case 3:
                double totalPoints = 0;
                for (int i = 0; i < n; i++) {
                    totalPoints += points[i];
                }
                System.out.println("Điểm TB" + (totalPoints/n)) ;
                break;
             case 4:
                 double max = points[0];
                double min = points[0];
                for (int i = 0; i < n; i++) {
                    if (points[i] > max){
                        max = points[i];
                    }
                    if(points[i] < min){
                        min = points[i];
                    }
                }
                 System.out.println("Điểm cao nhất là: " + max);
                 System.out.println("Điểm thấp nhất là: " + min);
                 break;
            case 5:
                int pass = 0;
                for (int i = 0; i < n; i++) {
                    if (points[i] >= 5) {
                        pass++;
                    }
                }
                System.out.println("Số lượng sinh viên đạt là: " + pass);
                System.out.println("Số lượng sinh viên không đạt là: " + (n-pass));
                break;
            case 6:
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (points[i] > points[j]) {
                            double temp = points[i];
                            points[i] = points[j];
                            points[j] = temp;
                        }
                    }
                }
                System.out.println("Điểm sau khi sắp xêp tăng dần sẽ là: ");
                for (int i = 0; i < n; i++) {
                    System.out.println(points[i]);
                }
                break;
            case 7:
                int count = 0;
                for (int i = 0; i < n; i++) {
                    if (points[i] >= 8 && points[i] < 9) {
                        count++;
                        System.out.println("Số lượng ho sinh giỏi là: " + count);
                        count = 0;
                    }
                    if (points[i] >= 9) {
                        count++;
                        System.out.println("Số lượng học sinh xuất sắc là: " + count);
                        count = 0;
                    }
                }
                break;
            case 8:
                System.exit(0);
            default:
                System.err.println("Vui lòng chọn lại");
        }
        }
    }
}
