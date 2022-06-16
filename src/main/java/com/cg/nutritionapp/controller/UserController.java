package com.cg.nutritionapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.nutritionapp.config.JwtTokenProvider;
import com.cg.nutritionapp.exceptions.UserExceptions;
import com.cg.nutritionapp.model.User;
import com.cg.nutritionapp.service.UserService;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = {"https://nutritics-frontend.herokuapp.com","https://localhost:3000"})
@RestController
@RequestMapping("api/v1")
//for front-end
public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	//listing users 
	@GetMapping("/user/listUsers")
	public ResponseEntity<List<User>> listUsers(){
		try {
		List<User> listOfUsers = userService.listUsers();
		return new ResponseEntity<>(listOfUsers,HttpStatus.OK);
		}catch(UserExceptions u) {
			log.error("Error in UserList");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	//creatingUser 
	@PostMapping("/user/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
	try {
		User newuser= userService.createUser(user);
		log.info("User succesfully added");
		return new ResponseEntity<>(newuser,HttpStatus.CREATED);
	} catch(UserExceptions u) {
			log.error("User is not created successfully");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
	}
}	


	//Registering User
	@PutMapping("/user/registerUser")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		try {
			User registeruser = userService.registerUser(user);
			log.info("User registered succesfully added");
			return new ResponseEntity<>(registeruser,HttpStatus.CREATED);
		}catch(UserExceptions u) {
			log.error("error in registerUser");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	//UpdateProfile  
	@PutMapping("/user/updateProfile")
	public ResponseEntity<User> profileUpdate(@RequestParam (name="id") Long id,@RequestBody User user){
		try {
			userService.profileUpdate(user,id);
			log.info("User profile succesfully added");
			return new ResponseEntity<User>(HttpStatus.OK);
		}catch(UserExceptions ur) {
			log.error("Error in profile update");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	

	//activateOrBlockUser 
	@PutMapping("/user/activateOrBlockUser")
	public ResponseEntity<Void> activateOrBlockUser(@RequestParam (name="id") Long id) {
		try {
			userService.activateOrBlockUser(id);
			log.info("User block or active");
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(UserExceptions ur) {
			log.error("Error in activateOrBlock User");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//Auntenticating User 
	@PostMapping(value = "/user/authenticateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> authenticate(@RequestBody User user) {
		log.info("UserResourceImpl : authenticate");
		JSONObject jsonObject = new JSONObject();
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			if (authentication.isAuthenticated()) {
				String email = user.getEmail();
				jsonObject.put("name", authentication.getName());
				jsonObject.put("authorities", authentication.getAuthorities());
				jsonObject.put("token", tokenProvider.createToken(email, userService.findByEmail(email).getRole()));
				return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
			}
		} catch (JSONException e) {
			try {
				jsonObject.put("exception", e.getMessage());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
		}
		return null;
	}
	
	
	
	//changing the Password  
	@PutMapping("/user/changePassword")
	public ResponseEntity<Void>  changePassword(@RequestParam (name="id") Long id,@RequestParam (name="oldPassword")String oldPassword,@RequestParam (name="newPassword") String newPassword){
		try {
			userService.changePassword(id,oldPassword,newPassword);
			log.info("change user password");
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(UserExceptions ur) {
			log.error("Error in changePassword");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}	
	
	
	@DeleteMapping("/user/removeUser")  
	public ResponseEntity<Void> removeUser(@RequestParam (name="id") Long id,@RequestBody User user){
		try {
			userService.removeUser(user,id);
			log.info("User deleted successfully");
			return new ResponseEntity<Void>(HttpStatus.OK);
		}catch(UserExceptions u) {
			log.error("Error Found:-->"+u);
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	
	

}
