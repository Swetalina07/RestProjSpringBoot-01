package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public User getUserById(Long id)
	{
		Optional<User> byId = repo.findById(id);
		if(byId.isPresent())
		{
			User user = byId.get();
			return user;
		}
		else
		{
			return null;
		}
		//return repo.findById(id).orElse(null);
	}
	
	public List<User> getAllUsers()
	{
		return repo.findAll();
	}
	public User saveUser(User user)
	{
		log.info("save:{}",user);
		User save = repo.save(user);
		log.info("save after DB:{}",user);
		return save;
	}
	public List<User> saveAllUsers(List<User> users)
	{
		log.info("save all:{}",users);
		List<User> saveAll = repo.saveAll(users);
		return saveAll;
	}
	
	public Long getTotalUsers()
	{
		 long count = repo.count();
		 return count;
	}
	public String deleteUser(Long id)
	{
		repo.deleteById(id);
		return "User deleted successfully";
	}
	public void deleteAllUser()
	{
		repo.deleteAll();
	}
	public List<User> findByName(String name)
	{
		List<User> byName = repo.findByName(name);
		return byName;
	}
	public Long countUsersByCity(String city)
	{
		Long countByCity = repo.countByCity(city);
		return countByCity;
	}
	public User getUsersbyIdAndCity(Long id,String city)
	{
		User byIdAndCity = repo.findByIdAndCity(id, city);
		return byIdAndCity;
	}
	public List<String> getAllUsersName()
	{
		List<String> allUsersName = repo.findAllUsersName();
		return allUsersName;
	}
	
	public String updateUserCityById(String city,Long id)
	{
		Optional<User> byId = repo.findById(id);
		if(byId.isPresent())
		{
			User user = byId.get();
			user.setCity(city);
			repo.save(user);
			return "City updated";
		}
		return "User's Id not found";
	}
	
	
}
