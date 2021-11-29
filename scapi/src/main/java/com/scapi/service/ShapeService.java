package com.scapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scapi.repository.ShapeRepository;
import com.scapi.shape.Shape;

@Service
public class ShapeService {
	
	private final ShapeRepository shapeRepository;
	
	@Autowired
	public ShapeService(ShapeRepository shapeRepository) {
		this.shapeRepository = shapeRepository;
	}
	
//	public List<Shape> getShapes() {
//				return shapeRepository.findAll();
//	}
//
//	public void addNewShape(Shape shape) {
//		System.out.println(shape);
//	}

}