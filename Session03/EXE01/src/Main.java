import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập tên Khách Hàng");
        String customerName = sc.nextLine();
        System.out.println("Mời bạn nhập tên Sản Phẩm");
        String productName = sc.nextLine();
        System.out.println("Mời bạn nhập Giá Sản Phẩm");
        double price = Double.parseDouble( sc.nextLine() );
        System.out.println("Mời bạn nhập so luong Sản Phẩm");
        int quantity = Integer.parseInt( sc.nextLine() );
        System.out.println("Mời bạn nhập thanh vien");
        boolean memberCard = Boolean.parseBoolean( sc.nextLine() );
        double amount = price * quantity;
        double discount = 0.0;
        double vat = amount*0.08;

        if (memberCard){
            discount = amount * 0.1;
        }
        double totalAmount = amount + vat - discount;
        System.out.println("Khach hang" +customerName);
        System.out.println("San Pham" + productName);
        System.out.println("Gia" + price);
        System.out.println("So luong" + quantity);
        System.out.println("thanh tien" + amount);
        System.out.println("Giam gia" + discount);
        System.out.println("tien VAT" + vat);
        System.out.println("Tong Tien" + totalAmount);
            }
}