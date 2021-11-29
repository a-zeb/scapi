package com.scapi.shape;

public class Square extends Shape {
	
    public Shape calculateArea(Shape shape) {
        shape.setArea((double)(shape.getDimension1()*shape.getDimension1()));
        return shape;
    }

}