package com.cg.nutritionapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cg.nutritionapp.model.Role;
import com.cg.nutritionapp.model.User;
import com.cg.nutritionapp.service.RoleService;
import com.cg.nutritionapp.service.UserService;
import com.cg.nutritionapp.utils.ConstantUtils;

@SpringBootApplication
public class NutritionAppApplication {

    @Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(NutritionAppApplication.class, args);
    }
    
    
    @Override
	public void run(String... args) throws Exception {
		if (roleService.findAll().isEmpty()) {
			roleService.saveOrUpdate(new Role(ConstantUtils.ADMIN.toString()));
			roleService.saveOrUpdate(new Role(ConstantUtils.USER.toString()));
		}

		if (userService.listUsers().isEmpty()) {
			User user1 = new User();
			user1.setEmail("test@user.com");
			user1.setName("Test User");
			user1.setContact("9787456545");
			user1.setRole(roleService.findByName(ConstantUtils.USER.toString()));
			user1.setPassword(new BCryptPasswordEncoder().encode("testuser"));
			userService.createUser(user1);

			User user2 = new User();
			user2.setEmail("test@admin.com");
			user2.setName("Test Admin");
			user2.setContact("9787456545");
			user2.setRole(roleService.findByName(ConstantUtils.ADMIN.toString()));
			user2.setPassword(new BCryptPasswordEncoder().encode("testadmin"));
			userService.createUser(user2);
		}
	}


}
