package Exer02;

public abstract class Vehicle {
    private String name;
    private int speed;
    public Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    // Phương thức trừu tượng
    public abstract void displayInfo();
    // Phương thức thông thường
    public void start(){
        System.out.println("Vehicle is starting...");
    }
    public String getName(){
        return name;
    }
    public int getSpeed(){
        return speed;
    }
}
