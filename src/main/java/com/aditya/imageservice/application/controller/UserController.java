package com.aditya.imageservice.application.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.imageservice.application.dto.UserDto;
import com.aditya.imageservice.application.entity.User;
import com.aditya.imageservice.application.exception.UserNotFoundException;
import com.aditya.imageservice.application.model.UserRequest;
import com.aditya.imageservice.application.model.UserResponse;
import com.aditya.imageservice.application.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public ResponseEntity<List<UserResponse>> getAllUsers()
	{
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.getAllUsers());
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<UserResponse> getUser(@PathVariable String username) throws UserNotFoundException
	{
		User user = userService.getUser(username);
		if(user == null) {
			throw new UserNotFoundException("User not found with username : " + username);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserResponse userResponse = mapper.map(user, UserResponse.class);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userResponse);
	}
	
	@PostMapping("")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest)
	{
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = mapper.map(userRequest, UserDto.class);
		UserResponse userResponse = userService.createUser(userDto);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userResponse);
	}
	
	@GetMapping("/or")
	public ResponseEntity<UserResponse> findByUsernameOrEmail(@RequestParam String username, @RequestParam String email) throws UserNotFoundException
	{
		User user = userService.findByUsernameOrEmail(username, email);
		if(user == null) {
			throw new UserNotFoundException("User not found with username : " + username + " or email : " + email);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserResponse userResponse = mapper.map(user, UserResponse.class);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userResponse);
	}
	
	@GetMapping("/and")
	public ResponseEntity<UserResponse> findByUsernameAndEmail(@RequestParam String username, @RequestParam String email) throws UserNotFoundException
	{
		User user = userService.findByUsernameAndEmail(username, email);
		if(user == null) {
			throw new UserNotFoundException("User not found with username : " + username + " and email : " + email);
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserResponse userResponse = mapper.map(user, UserResponse.class);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userResponse);
	}
}
