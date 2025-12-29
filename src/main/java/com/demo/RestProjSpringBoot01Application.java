package com.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.demo.entity.User;
import com.demo.repository.UserRepository;

@SpringBootApplication
public class RestProjSpringBoot01Application {
 
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(RestProjSpringBoot01Application.class, args);
		UserRepository bean = ctx.getBean(UserRepository.class);
		List<User> byCity = bean.findByCity("Kolkata");
		System.out.println(byCity.size());
		
		Long city = bean.countByCity("Kolkata");
		System.out.println(city);
		List<String> allUsersName = bean.findAllUsersName();
		System.out.println(allUsersName);
		List<String[]> nameAndEmail = bean.findNameAndEmail();
		for(int i=0;i<nameAndEmail.size();i++)
		{
			//System.out.println(nameAndEmail.get(i));
			String[] strings = nameAndEmail.get(i);
			System.out.println(strings[1]);
//			for(int j=0;j<strings.length;j++)
//			{
//				System.out.println(strings[j]);
//			}
		}
//		String[] strings = nameAndEmail.get(0);
//		for(int i=0;i<strings.length;i++)
//		{
//			System.out.println(strings[i]);
//		}
//		System.out.println(nameAndEmail.size());
		//System.out.println(nameAndEmail.get(0));
	}

}
