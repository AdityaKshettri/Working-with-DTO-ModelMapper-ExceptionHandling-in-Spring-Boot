package com.aditya.imageservice.application.initializer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aditya.imageservice.application.entity.Image;
import com.aditya.imageservice.application.repository.ImageRepository;

@Component
public class ApplicationInitializer implements CommandLineRunner 
{
	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public void run(String... args) throws Exception {
		imageRepository.save(new Image(UUID.randomUUID() ,"demourl"));
	}

}
