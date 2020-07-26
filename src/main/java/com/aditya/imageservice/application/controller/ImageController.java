package com.aditya.imageservice.application.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.imageservice.application.entity.Image;
import com.aditya.imageservice.application.service.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController 
{
	@Autowired
	private ImageService imageService;
	
	@GetMapping("")
	public ResponseEntity<List<Image>> findAll() {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(imageService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Image>> findById(@PathVariable UUID id) {
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.body(imageService.findById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Image image) {
		Image uploadedImage = imageService.save(image);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(uploadedImage);
	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Image image) {
		Image updatedImage = imageService.save(image);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(updatedImage);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable UUID id) {
		imageService.deleteById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Successfully deleted image at id : "+id);
	}
}
