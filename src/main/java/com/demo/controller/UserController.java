package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")//{"http://127.0.0.1:5500","http://localhost:8082"})
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	@Autowired
	private UserService service;
	@PostMapping("/save")
	public User userAdd(@RequestBody User use)
	{
		log.info("save Api user :{}",use);
		return service.saveUser(use);//User(id=1,name=Sweta,email=heqi@haf,city=askjfa)
	}
	
	@GetMapping("/findall")
	public List<User> getUsers()
	{
		log.info("findAll Api");
		return service.getAllUsers();
	}
	@GetMapping("/byid")
	public User getuserById(@RequestParam Long id)
	{
		log.info("find by id:{}",id);
		User userById = service.getUserById(id);
		return userById;
	}
	@GetMapping("/byname")
	public List<User> getUserByName(@RequestParam String name)
	{
		log.info("find by name:{}",name);
		List<User> byName = service.findByName(name);
		return byName;
	}
	
	@PostMapping("/saveall")
	public List<User> saveUsers(@RequestBody List<User> users)
	{
		log.info("save ev`ery users:{}",users);
		List<User> saveAllUsers = service.saveAllUsers(users);
		return saveAllUsers;
		//return null;
	}
	
	@GetMapping("/countbycity/{city}")
	public Long countUsers(/* @RequestParam */ @PathVariable String city)
	{
		log.info("Count users by city:{}",city);
		Long countUsersByCity = service.countUsersByCity(city);
		return countUsersByCity;
	}
	
	@GetMapping("/idandcity")
	public User getByIdAndCity(@RequestParam(required = false) Long id,@RequestParam String city)
	{
		log.info("get user by id:{} and city:{}",id,city);
		User usersbyIdAndCity = service.getUsersbyIdAndCity(id, city);
		log.info("after service method calling :{}",usersbyIdAndCity);
		return usersbyIdAndCity;
	}
	@GetMapping("/findallusersname")
	public List<String> getUserNames()
	{
		log.info("get all users name:{}");
		List<String> allUsersName = service.getAllUsersName();
		return allUsersName;
	}
	
	@GetMapping("/deletebyid")
	public String deleteUserById(@RequestParam Long id)
	{
		log.info("deleted user by id",id);
		String deleteUser = service.deleteUser(id);
		return deleteUser;
	}
	
	
	@PutMapping("/updatecitybyid/{id}")
	public String updateByIdUserCity(@RequestParam String city,@PathVariable Long id)
	{
		log.info("updated data",city+" "+id);
		String updateUserCityById = service.updateUserCityById(city, id);
		return updateUserCityById;
	}
}
