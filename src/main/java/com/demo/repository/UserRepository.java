package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public List<User> findByName(String name);
	@Query("SELECT COUNT(u) FROM User u WHERE u.city = :city")
	Long countByCity(@Param("city") String city);
	public List<User> findByCity(String city);
	public User findByIdAndCity(Long id,String city);
	public List<User> findByNameOrCity(String name,String city);
	//@Query("select u.name  from User u")//jpql
	@Query(value = "SELECT name FROM userrrr", nativeQuery = true)//native query
	public List<String> findAllUsersName();
	@Query(value = "select name , email from userrrr", nativeQuery = true)
	public List<String[]> findNameAndEmail();
	
	@Query("UPDATE User u SET u.city = :city WHERE u.id = :id")
	public String updateCityById(@Param("city") String city, @Param("id") Long id);
}
