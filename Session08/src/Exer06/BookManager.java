package Exer06;

import java.util.ArrayList;
import java.util.List;
import java.util.spi.AbstractResourceBundleProvider;

public class BookManager implements IBookManager{
    private List<Book> bookList;
    public BookManager(){
        bookList = new ArrayList<>();
    }
    @Override
    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("Đã thêm sách " + book.getDetails());
    }

    @Override
    public void removeBook(String isbn) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getIsbn().equals(isbn)) {
                bookList.remove(i);
                System.out.println("Đã xoá sách ISBN " + isbn);
                return;
            }
        }
        System.out.println("Không tìm thấy sách với ISBN " + isbn);
    }

    @Override
    public void displayBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Không có sách nào trong danh sách");
            return;
        }
        System.out.println("Danh sách sách: ");
        for (Book book : bookList) {
            System.out.println(book.getDetails());
        }
    }
}
