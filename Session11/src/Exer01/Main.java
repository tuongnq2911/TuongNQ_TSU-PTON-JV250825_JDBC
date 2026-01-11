package Exer01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Tạo danh sách số nguyên
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //Sử dụng labda expression đẻ in ra tất cả các số chẵn
        System.out.println("Các số cẵn trong danh sách là: ");
        numbers.forEach(number -> {
            if (number%2==0)
                System.out.println(number);
        });

        //Sử dụng phương thức tham chiếu để tính tổng của tất cả các số trong danh sách
        int sum = numbers.stream().mapToInt(number -> number).sum();
        System.out.println("Tổng của tất cả các số trong danh sách là: " + sum);
    }
}
