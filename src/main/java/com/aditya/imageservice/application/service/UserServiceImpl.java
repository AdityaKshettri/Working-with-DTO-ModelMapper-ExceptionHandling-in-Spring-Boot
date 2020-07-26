package com.aditya.imageservice.application.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aditya.imageservice.application.dto.UserDto;
import com.aditya.imageservice.application.entity.User;
import com.aditya.imageservice.application.model.UserResponse;
import com.aditya.imageservice.application.repository.UserRepository;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserResponse createUser(UserDto userDto) 
	{
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user = mapper.map(userDto, User.class);
		userRepository.save(user);
		UserResponse userResponse = mapper.map(user, UserResponse.class);
		return userResponse;
	}

	@Override
	public List<UserResponse> getAllUsers() 
	{
		List<User> users = userRepository.findAll();
		List<UserResponse> userResponses = new ArrayList<UserResponse>();
		for(User user: users)
		{
			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			UserResponse userResponse = mapper.map(user, UserResponse.class);
			userResponses.add(userResponse);
		}
		return userResponses;
	}

	@Override
	public User findByUsernameOrEmail(String username, String email) 
	{
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user = userRepository.findByUsernameOrEmail(username, email);
		return user;
	}

	@Override
	public User findByUsernameAndEmail(String username, String email) 
	{
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user = userRepository.findByUsernameAndEmail(username, email);
		return user;
	}

	@Override
	public User getUser(String username) 
	{
		
		User user = userRepository.findByUsername(username);
		return user;
	}
	
}
