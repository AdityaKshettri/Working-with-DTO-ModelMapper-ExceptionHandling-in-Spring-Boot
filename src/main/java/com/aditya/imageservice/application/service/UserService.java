package com.aditya.imageservice.application.service;

import java.util.List;

import com.aditya.imageservice.application.dto.UserDto;
import com.aditya.imageservice.application.entity.User;
import com.aditya.imageservice.application.model.UserResponse;

public interface UserService 
{
	public UserResponse createUser(UserDto userDto);
	public List<UserResponse> getAllUsers();
	public User findByUsernameOrEmail(String username, String email);
	public User findByUsernameAndEmail(String username, String email);
	public User getUser(String username);
}
