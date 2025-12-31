package Exer05;

public class CategoryManagement implements ICRUD {
    private Category[] categories = new Category[100]; // Mảng để lưu danh mục
    private int count = 0; // Số lượng danh mục hiê tại
    public void addCategory(Category category) {
        if(count < categories.length) {
            categories[count++] = category;
        }else {
            System.out.println("Mảng đã đầy, không thể thêm danh mục");
        }
    }

    public Category[] findAll() {
        Category[] result = new Category[count];
        System.arraycopy(categories, 0, result, 0, count);
        return result;
    }

    public void updateCategory(Category category) {
        for (int i = 0; i < count; i++) {
            if(categories[i].getId() == category.getId()) {
                categories[i] = category;
                return;
            }
        }
        System.out.println("Danh muc không tìm thấy.");
    }

    public void deleteById(int id) {
        for (int i = 0; i < count; i++) {
            if(categories[i].getId() == id) {
                for(int j = i; j < count - 1; j++) {
                    categories[j] = categories[j + 1]; // Dịch chuyển mảng
                }
                categories[--count] = null; // Giảm số lượng và xoá phần tử cuối
                System.out.println("Danh mục đã được xoá");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục ID: " + id);
    }
}
