package Exer01;

public class Main {
    public static void main(String[] args) {
        // Tạo mảng để lưu Dog and Cat
        Animals[] animalsArray = new Animals[2];
        // Tạo đối tượng Dog and Cat
        Dog dog1 = new Dog("Bubby", 3, "Golden Retriever" );
        Cat cat1 = new Cat("Whiskers", 2, "Ghi");
        // Thêm dog1 và cat1 vào mảng
        animalsArray[0] = dog1;
        animalsArray[1] = cat1;
        // Hiển thị thông tin và âm thanh của từng đối tượng tương ứng
        for (Animals animals : animalsArray) {
            animals.displayInfo();
            System.out.println("Âm Thanh " + animals.makeSound());
            System.out.println();
        }
    }
}
