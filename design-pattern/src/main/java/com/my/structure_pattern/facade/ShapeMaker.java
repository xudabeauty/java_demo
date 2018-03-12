package com.my.structure_pattern.facade;

public class ShapeMaker {
    private Circle circle;
    private Square square;
    public ShapeMaker() {
        circle=new Circle();
        square=new Square();
    }
    public void drawCircle() {
        circle.draw();
    }
    public void drawSquare() {
        square.draw();
    }
}
