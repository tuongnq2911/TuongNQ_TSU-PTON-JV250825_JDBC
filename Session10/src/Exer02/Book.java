package Exer02;

public class Book {
    private String title;
    private String author;
    private String yearPublisher;

    public Book(String title, String author, String yearPublisher) {
        this.title = title;
        this.author = author;
        this.yearPublisher = yearPublisher;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getYearPublisher() {
        return yearPublisher;
    }
    public void setYearPublisher(String yearPublisher) {
        this.yearPublisher = yearPublisher;
    }
    @Override
    public String toString(){
        return "Tên sách: " + title + "Tác Giả  " + author + "Năm xuất bản:  " + yearPublisher;
    }
}
