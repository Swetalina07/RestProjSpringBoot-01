package com.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="userrrr")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String city;
	@Transient//(used to not making any column in database or not communicate with database.)
	private String address;
}
