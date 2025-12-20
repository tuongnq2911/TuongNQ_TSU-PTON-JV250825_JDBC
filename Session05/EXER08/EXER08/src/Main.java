import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập chuỗi cần nén");
        String input = sc.nextLine().trim();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        // Kiểm tra xem chuối nhập có phải là rỗng hoặc không phải là ký tư alphabet không
        if(input.isEmpty() || !input.matches("^[a-zA-Z]+$")) {
            System.out.println("Chuỗi kết quả là: \" rỗng hoặc sai mặc định \" ");
            return;
        }
        // Xử lý chuỗi

        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for(int i = 0; i < input.length(); i++) {
            // Kiểm tra có ký tự giống nhau không nếu ký tự tại phần tử i và i + 1 giống nhau thì count++
            if(i+1 < input.length() && input.charAt(i) == input.charAt(i+1)) {
                count++;
            }else {
                // Nếu khác ký tự hoặc là ký tự cuối cùng thì thực hiện nối vào Stringbilder
                compressed.append(input.charAt(i));
                compressed.append(count);
                // reset lại biến đếm để tiến hành nén ký tự tiếp theo
                count = 1;
            }
        }
        // In kết quả
        System.out.println("Chuỗi sau khi được nén là: " + compressed.toString());
    sc.close();
    }
}