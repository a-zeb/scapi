package com.scapi.shape;

public class Rectangle extends Shape {
	
    public Shape calculateArea(Shape shape) {
    	shape.setArea((double)(shape.getDimension1()*shape.getDimension2()));
    	return shape;
    }

}