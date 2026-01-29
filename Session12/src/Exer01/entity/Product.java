package Exer01.entity;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Product {
    private static int nextId = 1;
    private int productId;
    private String productName;
    private float productPrice;
    private int productQuantity;
    private String productCategory;
    private static Set<String> productNames = new HashSet<>();

    public Product() {
        this.productId = nextId++;
    }

    public Product(int productId, String productName, float productPrice, int productQuantity, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Product.nextId = nextId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void inputData(Scanner scanner) {

        while (true) {
            System.out.println("Nhập vào tên sản phẩm");
            String productName = scanner.nextLine();
            if (productName.length() <= 10 || productName.length() >= 50) {
                System.err.println("Tên sản phẩm phải có độ dài từ 10-50 ký tự");
            } else if (productNames.contains(productName)) {
                System.err.println("Tên đã tồn tại");
            } else {
                this.productName = productName;
                productNames.add(productName);
                break;
            }
        }

        while (true) {
            try {
                System.out.println("Nhập vào giá sản phẩm");
                float productPrice = Float.parseFloat(scanner.nextLine());
                if (productPrice <= 0) {
                    System.err.println("Giá sản phẩm phải lớn hơn 0");
                } else {
                    this.productPrice = productPrice;
                    break;
                }
            } catch (Exception e) {
                System.err.println("Giá sản phẩm phải là số");
            }
        }

        while (true) {
            System.out.println("Nhập vào loại sản phẩm");
            String productCategory = scanner.nextLine();
            if (productCategory.length() >= 200) {
                System.err.println(" Độ dài sản phẩm không được vượt quá 200 ký tự");
            } else {
                this.productCategory = productCategory;
                break;
            }
        }
        while (true) {
            try {
                System.out.println("Nhập vào số lượng sản phẩm");
                int productQuantity = Integer.parseInt(scanner.nextLine());
                if (productQuantity <= 0) {
                    System.err.println("Giá sản phẩm phải lớn hơn 0");
                } else {
                    this.productQuantity = productQuantity;
                    break;
                }
            } catch (Exception e) {
                System.err.println("Giá sản phẩm phải là số nguyên");
            }
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}
