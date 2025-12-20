import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời ban nhập vào chuỗi văn bản: ");
        String text = sc.nextLine();

        System.out.println("Mời bạn nhập vào từ khoá cần tìm: ");
        String wordToFind  = sc.nextLine();

        int index = text.indexOf(wordToFind);

        if (index != -1) {
            System.out.println("Từ khoá \"" +wordToFind + "\"nằm ở vị trí số: " + index);
        }else {
            System.out.println("Từ khoá cần không có trong chuỗi văn bản");
        }
        sc.close();
    }
}