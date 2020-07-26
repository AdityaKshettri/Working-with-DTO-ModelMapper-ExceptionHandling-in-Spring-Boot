package com.aditya.imageservice.application.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aditya.imageservice.application.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID>
{
	
}
