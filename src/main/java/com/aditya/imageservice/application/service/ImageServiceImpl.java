package com.aditya.imageservice.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.aditya.imageservice.application.entity.Image;
import com.aditya.imageservice.application.repository.ImageRepository;

@Service
@EnableTransactionManagement
public class ImageServiceImpl implements ImageService
{
	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	@Transactional
	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	@Override
	@Transactional
	public Image save(Image image) {
		return imageRepository.save(image);
	}

	@Override
	@Transactional
	public void deleteById(UUID id) {
		imageRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Optional<Image> findById(UUID id) {
		return imageRepository.findById(id);
	}
}
