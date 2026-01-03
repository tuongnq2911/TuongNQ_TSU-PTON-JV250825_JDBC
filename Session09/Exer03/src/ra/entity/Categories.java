package ra.entity;

import java.util.Scanner;

public class Categories implements IShop{
    private int catalogId;
    private String catalogName;
    private String description;
    private boolean catalogStatus;

    public Categories(){}

    public Categories(int catalogId, String catalogName, String description, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    // Phương thức Getter và Setter


    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    // Xây dựng phương thức inputData
    public void inputData(Scanner scanner, Categories[] arrCategories, int index){
        if (index == 0){
            this.catalogId = 1;
        }else {
            int maxId = arrCategories[0].getCatalogId();
            for (int i = 1; i < index; i++) {
                if (arrCategories[i].getCatalogId() > maxId){
                    maxId = arrCategories[i].getCatalogId();
                }
            }
            this.catalogId = maxId + 1;
        }

        // Catalog name
        while (true){
            System.out.println("Nhập vào tên danh mục");
            this.catalogName = scanner.nextLine();
            if(this.catalogName.length() <= 50){
                boolean isExit  = false;
                for (int i = 0; i < index; i++) {
                    if (arrCategories[i].getCatalogName().equalsIgnoreCase(this.catalogName) && arrCategories[i].getCatalogId() != this.catalogId){
                        isExit  = true;
                        break;
                    }
                }
                if (!isExit){
                    break;
                }else {
                    System.err.println("Tên danh mục đã tồn tại");
                }
            }else {
                System.err.println("Sai rồi. Tên danh mục tối đa có 50 ký tự thôi!!!");
            }
        }

        // Nhập mô tả
        System.out.println("Vui lòng nhập mô tả cho sản phẩm: ");
        this.description = scanner.nextLine();

        // Set trạng thái của sản phẩm
        while (true){
            System.out.println("Trạng thái của sản phẩm ( True/ False: ");
            String status = scanner.nextLine();
            if (status.equalsIgnoreCase("True") ||  status.equalsIgnoreCase("False")){
                this.catalogStatus = Boolean.parseBoolean(status);
                break;
            }
            System.err.println("Chỉ nhận nhập vào true hoặc false");
        }
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %-3d | Tên: %-20s | Mô tả: %-20s | Trạng thái: %s\n", catalogId, catalogName, description, catalogStatus ? "Hoạt động" : "Không hoạt động");
    }
}
