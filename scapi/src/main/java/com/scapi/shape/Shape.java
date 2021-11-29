package com.scapi.shape;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Shape {
	
	@Id
	@SequenceGenerator(name = "circle_sequence", sequenceName = "circle_sequence", allocationSize = 1)
	@GeneratedValue ( strategy = GenerationType.SEQUENCE, generator = "circle_sequence")
	private Long id;
	private String shape;
	private double dimension1;
	private double dimension2;
	private double area;
	
	public Shape() {}
	
	public Shape(String shape, double dimension1) {
		this.shape = shape;
		this.dimension1 = dimension1;
	}

	public Shape(Long id, String shape, double dimension1) {
		this.id = id;
		this.dimension1 = dimension1;
	}
	
	public Shape(String shape, double dimension1, double dimension2) {
		this.shape = shape;
		this.dimension1 = dimension1;
		this.dimension2 = dimension2;
	}
	
	public Shape(Long id, String shape, double dimension1, double dimension2) {
		this.id = id;
		this.shape = shape;
		this.dimension1 = dimension1;
		this.dimension2 = dimension2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public double getDimension1() {
		return dimension1;
	}

	public void setDimension1(double dimension1) {
		this.dimension1 = dimension1;
	}
	
	public double getDimension2() {
		return dimension2;
	}

	public void setDimension2(double dimension2) {
		this.dimension2 = dimension2;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

//	@Override
//	public String toString() {
//		return "Shapes [id=" + id + ", shape=" + shape + ", dimension1=" + dimension1 + ", dimension2=" + dimension2 + "]";
//	}
	
//	ObjectMapper objectMapper = new ObjectMapper();
//	Shape shape = (shape.get);
	
    public void calculateArea() {}

}
