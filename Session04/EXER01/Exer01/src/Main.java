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
        // nhập các giá trị cho mảng
        System.out.println(" Mời bạn nhập các giá trị cho mảng: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Giá trị thứ " + (i+1) + ":");
            array[i] = sc.nextInt();
        }
        // Sắp xếp mảng theo thuật toán chọn giam dần
        selectionSort(array);
        // Đầu ra
        System.out.println("Mảng đã sắp xếp theo thứ tự giảm dần:");
        for (int value : array) {
            System.out.print(value + " ");
        }

        // Phần tử lớn nhất
        System.out.println("\nPhần tử lớn nhất trong mảng: " + array[0]);
    }
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Hoan đổi vị trí phần tử
                int temp = array[maxIndex];
                array[maxIndex] = array[i];
                array[i] = temp;
        }
    }
}
