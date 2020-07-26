package com.aditya.imageservice.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aditya.imageservice.application.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
	public User findByUsernameOrEmail(String username, String email);
	public User findByUsernameAndEmail(String username, String email);
	public User findByUsername(String username);
}
