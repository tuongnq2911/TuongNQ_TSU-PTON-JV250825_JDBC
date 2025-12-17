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
        // thuật toán sắp xếp nổi bọt
        boolean swapped;
        for (int i = 1; i < size; i++) {
            swapped = false;
            for (int j = 0; j < size - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("Mang da duoc sap xep theo thu tu tang dan la :");
        for(int value : array) {
            System.out.print(value + " ");
        }
    }
}