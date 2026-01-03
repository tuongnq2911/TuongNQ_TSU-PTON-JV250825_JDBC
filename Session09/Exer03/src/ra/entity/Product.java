package ra.entity;

import java.util.Scanner;

public class Product implements  IShop {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int categoryId;
    private int productStatus;

    public Product(){}

    public Product(String productId, String productName, float price, String description, int categoryId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.productStatus = productStatus;
    }

    // Tạo phương thức getter và setter

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCatalog) {
        // ProductId
        while (true) {
            System.out.println("Nhập mã sản phẩm theo cú pháp (Cxxx/ Sxxx/ Axxx");
            this.productId = scanner.nextLine().toUpperCase();
            if(this.productId.matches("^[CSA].{3}$")){
                boolean isExit = false;
                for(int i = 0; i < indexProduct; i++){
                    if(arrProduct[i].getProductId().equals(this.productId)){
                        isExit = true;
                        break;
                    }
                }
                if(!isExit){
                    break;
                }else {
                    System.err.println("Mã sản phẩm đã tồn tại!");
                }
            }else {
                System.err.println("Mã sản phẩm phải bắt đầu bằng C, S, A và có đủ 4 ký tự!");
            }
        }

        // Product name
        while(true){
            System.out.println("Mời bạn nhập tên sản phẩm: ");
            this.productName = scanner.nextLine();
            if(this.productName.length()<= 50 && this.productName.length()>=10){
                boolean isExit = false;
                for(int i = 0; i < indexProduct; i++){
                    if(arrProduct[i].getProductName().equalsIgnoreCase(this.productName)){
                        isExit = true;
                        break;
                    }
                }
                if(!isExit){
                    break;
                }else {
                    System.err.println("Tên sản phẩm đã tồn tại");
                }
            }else {
                System.err.println("Độ dàu tên sản phẩm phải có tối thiêu từ 10 ký tự và không vượt quá 50 kỹ tự!!");
            }
        }

        // Nhập giá sản phẩm
        while(true){
            System.out.println("Nhập giá sản phẩm: ");
            this.price = Float.parseFloat(scanner.nextLine());
            if(this.price >= 0){
                break;
            }else {
                System.err.println("Giá phải lớn hơn 0!!");
            }
        }

        // Nhập mô tả
        System.out.println("Nhập mô tả: ");
        this.description = scanner.nextLine();

        // Chọn danh mục sản phẩm
        System.out.println("---DANH SÁCH DANH MỤC SẢN PHẨM---");
        for (int i = 0; i < indexCatalog; i++) {
            System.out.printf("%d. %s\n", arrCategories[i].getCatalogId(), arrCategories[i].getDescription());
        }
        System.out.println("Lựa chọn mã danh mục: ");
        this.categoryId = Integer.parseInt(scanner.nextLine());

        while(true){
            System.out.println("Trạng thái (0: Bán, 1: Hết, 2: Không bán): ");
            this.productStatus = Integer.parseInt(scanner.nextLine());
            if(this.productStatus < 0 || this.productStatus > 2){
                break;
            }
            System.err.println("Xin hãy chọn 0 hoặc 1 hoặc 2 !");
        }
    }

    @Override
    public void displayData() {
        String statusStr = (productStatus == 0) ? "Đang bán" : (productStatus == 1) ? "Hết hàng" : "Không bán";
        System.out.printf("ID: %-5s | Tên: %-20s | Giá: %-8.2f | Status: %s\n", productId, productName, price, statusStr);
    }
}
