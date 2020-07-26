package com.aditya.imageservice.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.aditya.imageservice.application.entity.Image;

public interface ImageService 
{
	public List<Image> findAll();
	public Image save(Image image);
	public void deleteById(UUID id);
	public Optional<Image> findById(UUID id);
}
