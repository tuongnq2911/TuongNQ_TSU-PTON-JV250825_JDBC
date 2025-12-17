import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Khởi tạo số phần từ mảng
        System.out.println(" Mời bạn nhập độ dài của mảng: ");
        int size = sc.nextInt();
        int[] array = new int[size];
        int sum = 0;
        // nhập các giá trị cho mảng
        System.out.println(" Mời bạn nhập các giá trị cho mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Giá trị thứ " + (i+1) + ":");
            array[i] = sc.nextInt();
        }
        for (int value : array) {
            sum += value;
        }
        System.out.printf("Tổng giá trí của %d phần từ trong mảng là %d\n", size, sum);
    }
}