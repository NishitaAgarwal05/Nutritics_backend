package com.cg.nutritionapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.nutritionapp.repository.UserDAO;
import com.cg.nutritionapp.exceptions.UserExceptions;
import com.cg.nutritionapp.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired 
	private UserDAO userDAO;
	
	//create User
	@Override 
	public User createUser(User user) throws UserExceptions{ 
				userDAO.saveAndFlush(user);
				return user;
	}
	
	//Profile Update
	@Override
	public User profileUpdate(User user, Long id) throws UserExceptions  {
		
		User currentuser = (userDAO.findById(id).orElse(null));
			if(currentuser!=null) {
				currentuser.setName(user.getName());
				currentuser.setContact(user.getContact());
				currentuser.setDob(user.getDob());
				// currentuser.setPhoto(user.getPhoto());
				currentuser.setEmail(user.getEmail());
				currentuser.setStatus(user.getStatus());
				currentuser.setWeight(user.getWeight());
				currentuser.setHeight(user.getHeight());
				currentuser.setDiateryOrientation(user.getDiateryOrientation());
				currentuser.setIntensity(user.getIntensity());
				currentuser.setGoal(user.getGoal());
				currentuser.setWorkOutTime(user.getWorkOutTime());
				currentuser.setWakeUpTime(user.getWorkOutTime());
				currentuser.setSleepTime(user.getSleepTime());
				currentuser.setMedicalCondition(user.getMedicalCondition());
				currentuser.setAllergicTo(user.getAllergicTo());
				// currentuser.setLoginName(user.getLoginName());
				currentuser.setPassword(user.getPassword());
				 return userDAO.saveAndFlush(currentuser);
				 
			}else {
				throw new UserExceptions();
			}
	}
	
	//List Users
	@Override
	public List<User> listUsers(){
		 return userDAO.findAll();
	}
	
	//activate or Block User
	@Override
	public void activateOrBlockUser(Long id) throws UserExceptions{
		User ur = userDAO.findById(id).orElse(null);
		if(ur!=null) {
			if(ur.getStatus().equalsIgnoreCase("active")) {
				ur.setStatus("block");
			}else {
				ur.setStatus("active");
			}
			userDAO.saveAndFlush(ur);
		 }else {
			 throw new UserExceptions("No user id present");
		}
  }
	
	//ChangePassword
	public void changePassword(Long id,String oldPassword, String newPassword) throws UserExceptions {
		User user = userDAO.findById(id).orElse(null);
		if(new BCryptPasswordEncoder().matches(oldPassword, user.getPassword())) {
			user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
			userDAO.saveAndFlush(user);
		}else {
			throw new UserExceptions("Wrong old Password");
		}	
	}
	
	@Override
	public User findByEmail(String email){
		return userDAO.findByEmail(email);
	}
}


