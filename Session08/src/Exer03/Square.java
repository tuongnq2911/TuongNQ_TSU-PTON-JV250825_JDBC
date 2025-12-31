package Exer03;

import java.awt.*;

public class Square implements Colorable {
    private double side;
    private String color;
    public Square(double size) {
        this.side = size;
    }

    public double getSize() {
        return side;
    }

    public void setSize(double size) {
        this.side = size;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
