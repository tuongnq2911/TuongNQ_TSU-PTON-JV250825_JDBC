package Exer05;

public interface ICRUD {
    Category[] findAll(); // Trả về mảng danh sách tất cả các danh mục.
    void addCategory(Category category); // Thêm một danh mục mới.
    void updateCategory(Category category); // Cập nhật một danh mục đã tồn tại.
    void deleteById(int id); // Xóa danh mục theo ID.
}
