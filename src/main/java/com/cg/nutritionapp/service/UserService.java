package com.cg.nutritionapp.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.cg.nutritionapp.exceptions.UserExceptions;
import com.cg.nutritionapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserService{

	
	public User createUser(User user) throws UserExceptions;  //to create User

	public User profileUpdate(User user, Long id) throws UserExceptions;  //to profileUpdate

	//list Users
	public List<User> listUsers() ;

	//User register
	public User registerUser(User user)  throws UserExceptions;

	//activate or Block User
	public void activateOrBlockUser(Long id) throws UserExceptions;

	//Authenticate User
	public User authenticateUser(String loginid, String password) throws UserExceptions;

	//change Password
	public void changePassword(Long id,String oldPassword, String newPassword) throws UserExceptions;

	public void removeUser(User user,Long id) throws UserExceptions;

	public User findByEmail(String email);

}
