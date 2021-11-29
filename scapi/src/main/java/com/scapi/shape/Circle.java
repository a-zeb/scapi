package com.scapi.shape;

public class Circle extends Shape {
	
    public Shape calculateArea(Shape shape) {
    	shape.setArea((double)(Math.PI*(shape.getDimension1()*shape.getDimension1())));
    	return shape;
    }

}