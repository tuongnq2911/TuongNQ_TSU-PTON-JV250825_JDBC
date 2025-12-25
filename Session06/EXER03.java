package Session06;

import java.util.Arrays;
import java.util.Scanner;

public class EXER03{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] carNumber = new  String[100];
        int n = 0;
        while(true) {
            System.out.println("\n******************QUẢN LÝ BIỂN SỐ XE****************");
            System.out.println("\n1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.println("Mời bạn nhập lựa chọn từ 1-6");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Thêm số biển số xe: ");
                    n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("Biển số xe thứ " + (i+1));
                        carNumber[i] = sc.nextLine();
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        System.out.println("Danh sách biển số xe đã nhập là: " + carNumber[i]);
                    }
                    break;
                case 3:
                    System.out.print("Nhập biển số cần tìm: ");
                    String finalNumber = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if(finalNumber.equals(carNumber[i])) {
                            System.out.println("Tìm thấy biển số xe cần tìm");
                            break;
                        }
                    }
                    System.out.println("Không tìm thấy biển số xe cần tìm");
                    break;

                case 4:
                    System.out.print("Nhập mã tỉnh cần tìm (VD: 29, 30): ");
                    String maTinh  = sc.nextLine().trim();
                    boolean found = false;
                    System.out.println("Kết quả tìm kiếm cho mã tỉnh " + maTinh + ":");
                    for(String bs: carNumber) {
                        if(bs != null && bs.length() >= 2) {
                            String maTinhTrichXuat = bs.substring(0, 2);
                            if(maTinhTrichXuat.equals(maTinh)) {
                                System.out.println(bs);
                                found = true;
                            }
                        }
                    }
                    if(!found) {
                        System.out.println("Không có biển nào thuộc mã tỉnh: " + maTinh);
                    }
                    break;
                case 5:
                    if (n == 0) {
                        System.out.println("Danh sách trống, không có gì để sắp xếp.");
                    } else {
                        // Sắp xếp mảng từ vị trí 0 đến n
                        Arrays.sort(carNumber, 0, n);
                        System.out.println("Đã sắp xếp biển số xe tăng dần.");

                        // Hiển thị lại danh sách sau khi sắp xếp
                        System.out.println("Danh sách sau khi sắp xếp:");
                        for (int i = 0; i < n; i++) {
                            System.out.println(carNumber[i]);
                        }
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn lại");
            }
        }
    }
}

