import java.util.Arrays;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Khởi tạo số phần từ mảng
        System.out.println(" Mời bạn nhập độ dài của mảng: ");
        int size = sc.nextInt();
        if (size <= 0) {
            System.out.println("Mang rong khong co gia tri");
            return;
        }
        int[] array = new int[size];

        // nhập các giá trị cho mảng
        System.out.println(" Mời bạn nhập các giá trị cho mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Giá trị thứ " + (i+1) + ":");
            array[i] = sc.nextInt();
        }
        // Hien thi mang ban dau
        System.out.print("Mang ban dau la: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
        // Dao nguoc mang
        for (int i = 0; i <size / 2; i++) {
            // Chỉ duyệt tới 1/2 mảng vì giá trị đầu tiên đổi cho giá trị ở vị trí size-1,
            // nếu duyệt hết thì mạng sẽ hoán đổi 2 lần và sẽ quay về mảng cũ
            int temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        // Hiển thị mảng đảo ngược
        System.out.println("Mảng sau khi đảo ngược là: " + Arrays.toString(array));
        sc.close();
    }
}