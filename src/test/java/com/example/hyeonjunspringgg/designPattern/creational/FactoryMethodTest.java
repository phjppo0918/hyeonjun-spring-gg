package com.example.hyeonjunspringgg.designPattern.creational;


interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {

    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {

    }
}

class ShapeFactory {
    public Shape getShape(String shapeType) {
        if(shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

public class FactoryMethodTest {

}
