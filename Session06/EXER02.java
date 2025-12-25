package Session06;

import java.util.Scanner;

public class EXER02 {
    public static void main(String[] args) {
        String fullName = "";
        String email = "";
        String phoneNumber = "";
        String password = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("******************QUẢN LÝ NGƯỜI DÙNG****************\n" +
                    "\n");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuan Hoa");
            System.out.println("3. Email co hop le khong ");
            System.out.println("4. Số điện thoại co hop le khong ");
            System.out.println("5. Password co hop le khong ");
            System.out.println("6. Thoat");
            System.out.println("Moi ban chon 1 - 6 ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập thông tin người dùng");
                    System.out.println("Nhập vào họ và tên: ");
                    fullName = sc.nextLine();
                    System.out.println("Nhập vào email người dùng: ");
                    email = sc.nextLine();
                    System.out.println("Mơi bạn nhập vào số điện thoại:");
                    phoneNumber = sc.nextLine();
                    System.out.println("Nhập vào password người dùng");
                    password = sc.nextLine();
                    break;
                case 2:
                    String[] words = fullName.trim().toLowerCase().split(" ");
                    StringBuffer sb = new StringBuffer();
                    for(String word : words){
                        sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
                    }
                    System.out.println(sb.toString());
                    break;
                case 3:
                    String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                    if (email.matches(emailRegex)){
                        System.out.println("Email hợp lệ");
                        break;
                    }else {
                        System.out.println("Email không hợp lệ");
                    }
                    break;
                case 4:
                    String phoneNumberRegex = "^(0|\\+84)(2|3|7|8|9)\\d{8}$";
                    if(phoneNumber.matches(phoneNumberRegex)){
                        System.out.println("Số điện thoại hợp lệ");
                        break;
                    }else {
                        System.out.println("Số điện thoại không hợp lệ vui lòng kiểm tra lại");
                    }
                    break;
                case 5:
                    String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?!\\s).{8,32}$";
                    if(password.matches(passwordRegex)){
                        System.out.println("Mật khẩu hợp lệ");
                        break;
                    }else {
                        System.out.println("Mật khẩu không hợp lệ");
                    }
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.err.println("Mời bạn nhập lại từ 1-6");
            }
        }while (true);
    }
}
