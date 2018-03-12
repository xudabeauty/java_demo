package com.my.structure_pattern.facade;

public class Client {
public static void main(String[] args) {
    ShapeMaker maker=new ShapeMaker();
    maker.drawCircle();
    maker.drawSquare();
}
}
