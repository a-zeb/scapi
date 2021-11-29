package com.scapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scapi.repository.ShapeRepository;
import com.scapi.service.ShapeService;
import com.scapi.shape.Circle;
import com.scapi.shape.Rectangle;
import com.scapi.shape.Shape;
import com.scapi.shape.Square;

import exceptions.ErrorResponse;
import exceptions.RecordNotFoundException;

@RestController
public class ShapeController {
	
	@SuppressWarnings("unused")
	private final ShapeService shapeService;
	
	@Autowired
	ShapeRepository repo;
	
	@Autowired
	public ShapeController(ShapeService shapeService) {
		this.shapeService = shapeService;
	}
	
	@DeleteMapping("/shape/{id}")
	public String deleteShape(@PathVariable long id) {
		Shape circle = repo.getById(id);
		repo.delete(circle);
		return "deleted";
	}
	
	@PostMapping(path="/shape")
	public Shape addShape(@RequestBody Shape shape) {
		String shapeString = cleanUp(shape.getShape());
		shape.setShape(shapeString);
		identifyShape(shape);
		repo.save(shape);
		return shape;
	}
	
	@GetMapping(path="/shape")
	public List<Shape> getShapes() {
		return repo.findAll();
	}
	
	@PutMapping(path="/shape/{id}")
	public ResponseEntity<Shape> updateShape(@PathVariable(value = "id") Long id, @Validated @RequestBody Shape shape) {
	    Shape updateShape = repo.findById(id).orElseThrow(() -> new RecordNotFoundException("Shape not found for this id :: " + id));
        String shapeString = cleanUp(shape.getShape());
        updateShape.setId(shape.getId());
        updateShape.setShape(shapeString);
        updateShape.setDimension1(shape.getDimension1());
        updateShape.setDimension2(shape.getDimension2());
        identifyShape(updateShape);
        final Shape finalShape = repo.save(updateShape);
        return ResponseEntity.ok(finalShape);
	    }
	
	@RequestMapping("/shape/{id}")
	public Optional<Shape> getShape(@PathVariable("id") Long id) {
		System.out.println(repo.findById(id));
		return repo.findById(id);
	}
	
    static String cleanUp(String userInput) {
        userInput = userInput.toLowerCase();
        return userInput.replaceAll("\\s", "");
    }
    
    public Shape identifyShape(Shape shape) {
    	String switchShape = shape.getShape();
        switch (switchShape) {
            case "circle" :
                Circle myCircle = new Circle();
                shape = myCircle.calculateArea(shape);
                return shape;
            case "square" :
            	Square mySquare = new Square();
            	mySquare.calculateArea(shape);
                return mySquare;
            case "rectangle" :
            	Rectangle myRectangle = new Rectangle();
            	myRectangle.calculateArea(shape);
                return myRectangle;
            default :
            	throw new ErrorResponse("Misspelling or incorrect input");
        }
    }

}

