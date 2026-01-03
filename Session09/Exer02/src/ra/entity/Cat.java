package ra.entity;

public class Cat extends Pet{
    public Cat() {}

    public Cat(String petId, String petName, int age) {
        super(petId,petName,age);
    }
    public void speak() {
        System.out.println("Meo Meo");
    }
}
