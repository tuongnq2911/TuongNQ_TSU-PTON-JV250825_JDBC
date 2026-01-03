package ra.presentation;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    private static Categories[] arrCategories = new Categories[100];
    private static Product[] arrProducts = new Product[100];
    private static int indexCatalog = 0;
    private static int indexProduct = 0;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:categoryMenu();break;
                case 2:productMenu();break;
                case 3:System.exit(0);break;
            }
        }
    }
    public static void categoryMenu(){
        while (true) {
            System.out.println("\n********************CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Quay lại");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 6) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Nhập thông tin nhiều danh mục: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        arrCategories[indexCatalog] = new Categories();
                        arrCategories[indexCatalog].inputData(sc, arrCategories, indexCatalog);
                        indexCatalog++;
                    }break;
                case 2:
                    for (int i = 0; i < indexCatalog; i++) {
                        arrCategories[i].displayData();
                    }break;
                case 3:
                    System.out.println("Cập nhật thông tin danh mục theo mã Danh mục: ");
                    int idEdit = Integer.parseInt(sc.nextLine());
                    int foundIndex = findCategoryById(idEdit);
                    if (foundIndex != -1) {
                        arrCategories[foundIndex].inputData(sc, arrCategories, indexCatalog);
                        arrCategories[foundIndex].setCatalogId(idEdit);// Giữ nguyên ID
                    }else{
                        System.err.println("Mã ID bạn nhập không tồn tại!!");
                    }
                        break;
                case 4:
                    System.out.println("Mời bạn nhập mã Danh Mục cần xoá: ");
                    int idDelete = Integer.parseInt(sc.nextLine());
                    int deletedIndex = findCategoryById(idDelete);
                    if(deletedIndex != -1){
                        boolean hasProduct = false;
                        for (int i = 0; i < indexProduct; i++) {
                            if (arrProducts[i].getCategoryId() == idDelete) {
                                hasProduct = true;
                                break;
                            }
                        }
                        if(!hasProduct){
                            for(int i = deletedIndex; i < indexCatalog - 1; i++){
                                arrProducts[i] = arrProducts[i+1];
                                indexCatalog--;
                                System.out.println("Xoá thành công!");
                            }
                        }else {
                            System.err.println("Mã danh mục không tồn tại nên không thể xoá!!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhập mã danh mục cần thay đổi trạng thái: ");
                    int idStatus = Integer.parseInt(sc.nextLine());
                    int statusIndex = findCategoryById(idStatus);
                    if(statusIndex != -1){
                        // Lấy danh mục hiện tại ra một biến tạm
                        Categories catalog = arrCategories[statusIndex];

                        // Kiểm tra trạng thái hiện tại và đảo ngược
                        if(catalog.isCatalogStatus() == true){
                            catalog.setCatalogStatus(false);
                        }else {
                            catalog.setCatalogStatus(true);
                        }
                        System.out.println("Cập nhật trạng thái thành công");
                    }else {
                        System.out.println("Mã danh mục nhập vào không tồn tại");
                    }
                    break;
            }
        }
    }
    // Quản lý sản phẩm
    public static void productMenu(){
        while (true) {
            System.out.println("\n*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Nhập thông tin sản phẩm");
            System.out.println("2. Hiển thị thông tin sản phẩm");
            System.out.println("3. Sắp xếp theo giá");
            System.out.println("4. Cập nhật thông tin");
            System.out.println("5. Xóa sản phẩm");
            System.out.println("6. Tìm kiếm theo tên");
            System.out.println("7. Tìm trong khoảng giá");
            System.out.println("8. Quay lại");
            System.out.print("Mời bạn nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 8) break;
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng thông tin các sản phẩm: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        arrProducts[indexProduct] = new Product();
                        arrProducts[indexProduct].inputData(sc, arrProducts, indexProduct, arrCategories, indexCatalog);
                        indexProduct++;
                    }
                    break;
                case 2:
                    for (int i = 0; i < indexProduct; i++) {
                        arrProducts[i].displayData();
                    }
                    break;
                case 3:
                    for (int i = 0; i < indexProduct - 1; i++) {
                        for (int j = i + 1; j < indexProduct; j++) {
                            if (arrProducts[i].getPrice() > arrProducts[j].getPrice()) {
                                Product temp =  arrProducts[i];
                                arrProducts[i] = arrProducts[j];
                                arrProducts[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sản phẩm theo giá tăng dần");
                    break;
                case 4:
                    System.out.println("Nhập mã sản phẩm cần cập nhật: ");
                    String idUpdate = sc.nextLine();
                    int updateIndex = -1;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProducts[i].getProductId().equals(idUpdate)) {
                            updateIndex = i;
                            break;
                        }
                    }
                    if (updateIndex != -1) {
                        arrProducts[updateIndex].inputData(sc, arrProducts, indexProduct, arrCategories, indexCatalog);
                        arrProducts[updateIndex].setProductId(idUpdate);// Giữ nguyên mã sản phẩm cũ
                        System.out.println("Cập nhật thành công!!");
                    }else {
                        System.err.println("Mã sản phẩm không tồn tại");
                    }break;
                case 5:
                    System.out.println("Nhập mã sản phẩm cần xoá: ");
                    String idDelete = sc.nextLine();
                    int deleteIndex = -1;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProducts[i].getProductId().equals(idDelete)) {
                            deleteIndex = i;
                            break;
                        }
                    }
                    if (deleteIndex != -1) {
                        for (int i = deleteIndex; i < indexProduct - 1; i++) {
                            arrProducts[i] = arrProducts[i + 1];
                        }
                        indexProduct--;
                        System.out.println("Xoá thông tin sản phẩm thành công");
                    }else {
                        System.err.println("Mã sản phẩm bạn nhập không tồn tại");
                    }break;
                case 6:
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    String searchName = sc.nextLine().toLowerCase();
                    boolean isFound = false;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProducts[i].getProductName().toLowerCase().contains(searchName.toLowerCase())) {
                            arrProducts[i].displayData();
                            isFound = true;
                        }
                    }
                    if (!isFound) {
                        System.err.println("Không tìm thấy tên sản phẩm nào!!");
                    }break;
                case 7:
                    System.out.println("Mời bản nhập khoảng giá thấp nhất; ");
                    float minPrice  = Float.parseFloat(sc.nextLine());
                    System.out.println("Mời bạn nhập khoảng giá cao nhất: ");
                    float maxPrice = Float.parseFloat(sc.nextLine());
                    boolean hasResult = false;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProducts[i].getPrice() >= minPrice &&  arrProducts[i].getPrice() <= maxPrice) {
                            arrProducts[i].displayData();
                            hasResult = true;
                        }
                    }
                    if (!hasResult) {
                        System.err.println("Không có sản phẩm nào trong khoảng giá này");
                    }break;
                default:
                    System.err.println("Vui lòng nhập lựa chọn từ 1-8!!");
            }
        }
    }

    private static int findCategoryById(int id){
        for (int i = 0; i < indexCatalog; i++){
            if(arrCategories[i].getCatalogId() == id){
                return i;
            }
        }
        return -1;
    }
}
