package Exer03;

import java.util.Scanner;

public class InputData03 {
    public static String getString(Scanner sc, String suggest) {
        String input = "";
        do {
            System.out.println(suggest);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Vui lòng không đợc để trống !");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getInt(Scanner sc, String suggest) {
        String result = "";
        do {
            System.out.println(suggest);
            result = sc.nextLine();
            try {
                if (result.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống !");
                } else if (Integer.parseInt(result) < 0) {
                    System.out.println("Vui lòng nhập số nguyên >= 0 !");
                }else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Vui lòng nhập số nguyên >= 0 !");
            }
        }while (true);
        return Integer.parseInt(result);
    }

    public static double getDouble(Scanner sc, String suggest) {
        String result = "";
        do {
            System.out.println(suggest);
            result = sc.nextLine();
            try {
                if (result.isEmpty()) {
                    System.out.println("Vui lòng không bỏ trống !");
                } else if (Double.parseDouble(result) < 0) {
                    System.out.println("Vui lòng nhập vào số thực >= 0 !");
                }else  {
                    break;
                }
            }catch (Exception e) {
                System.out.println("Vui lòng nhập vào ố thực >= 0 !");
            }
        }while (true);
        return Double.parseDouble(result);
    }
}
