package Exer02;

public class Bike extends Vehicle{
    public Bike(String name, int speed){
        super(name, speed);
    }
    public void displayInfo(){
        System.out.println("Bike Name: " + getName() + " Speed: " + getSpeed() + "km/h");
    }
}
