package Exer01.business;

import Exer01.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductBusiness {
    private static List<Product> productList = new ArrayList<>();

    public static void addProduct(Scanner scanner) {
        Product  product = new Product();
        product.inputData(scanner);
        productList.add(product);
    }

    public static void displayProducts() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public static Product findProductById(int productId) {
        for (Product product : productList) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Mời bạn nhập vào mã sản phẩm cần sửa");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = findProductById(id);
        if (product != null) {
            System.out.println("Nhâp vào tên mới cần sửa: ");
            product.setProductName(scanner.nextLine());
            System.out.println("Nhập vào giá mơi: ");
            product.setProductPrice(Float.parseFloat(scanner.nextLine()));
            System.out.println("Nhập vào danh mục mới: ");
            product.setProductCategory(scanner.nextLine());
            System.out.println("Nhập vào số lượng sản phẩm mới: ");
            product.setProductQuantity(Integer.parseInt(scanner.nextLine()));
        }else {
            System.err.println("Không tìm thấy sản phẩm nào có mã ID: " + id);
        }
    }

    public static void deleteProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần xoá: ");
        int id = Integer.parseInt(scanner.nextLine());
        Product product = findProductById(id);
        if (product != null) {
            productList.remove(product);
            System.out.println("Xoá thành công sản phẩm có mã ID: "+ id);
        }else {
            System.err.println("Không tìm thấy sản phẩm cần xoá có ID: " +id);
        }
    }

    public static void searchProductByName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm cần tìm: ");
        String productName = scanner.nextLine();
        for (Product product : productList) {
            if(product.getProductName().toLowerCase().contains(productName.toLowerCase()) ) {
                System.out.println(product.toString());
            }
        }
    }

    public static void sortProductByPriceASC() {
        productList.sort((o1, o2) -> (int) (o1.getProductPrice() - o2.getProductPrice()));
        System.out.println("Danh sách đã được sắp xếp theo giá tăng dần là: ");
        displayProducts();
    }

    public static void sortProductByQuantityDESC(){
        productList.sort((o1, o2) -> o2.getProductQuantity() - o1.getProductQuantity());
        System.out.println("Danh sách đã được sắp xếp theo số lượng giảm ần là: ");
        displayProducts();
    }
}
