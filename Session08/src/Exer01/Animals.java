package Exer01;

public class Animals {
    private String name;
    private int age;
    public Animals(String name, int age) {
        if (name == null || name.isEmpty()) {
            throw  new IllegalArgumentException("Tên không được để trống");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi phải lớn hơn hoặc bằng 0");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    // Phương thức hiển thị thông tin chung
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    // Phương thức âm thanh
    public String makeSound() {
        return "Some generic sound";
    }
}
