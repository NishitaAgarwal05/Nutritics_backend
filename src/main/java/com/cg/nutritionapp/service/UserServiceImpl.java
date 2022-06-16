package com.cg.nutritionapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		
				userDAO.save(user);
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
				currentuser.setPhoto(user.getPhoto());
				currentuser.setEmail(user.getEmail());
				currentuser.setRole(user.getRole());
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
				currentuser.setLoginName(user.getLoginName());
				currentuser.setPassword(user.getPassword());
				 return userDAO.save(currentuser);
				 
			}else {
				throw new UserExceptions();
			}
		
				 
				
	}
	
	//List Users
	@Override
	public List<User> listUsers(){
		 return userDAO.findAll();
	}
	
	//RegisterUser
	@Override 
	public User registerUser(User user)throws UserExceptions {
		user = userDAO.save(user);
		return user;
	}
	
	
	//activate or Block User
	@Override
	public void activateOrBlockUser(Long id) throws UserExceptions{
		
		
			User ur = userDAO.findById(id).orElse(null);
		
			if(ur!=null) {
		
			if(ur.getStatus().equals("active")) {
				ur.setStatus("Block");
			}else {
				ur.setStatus("active");
			}
			userDAO.save(ur);
		 }else {
			 throw new UserExceptions("No user id present");
			
		}
	
		
  }
	
	//AuthenticateUser 
	public User authenticateUser(String loginid, String password) throws UserExceptions {
		
		User ur = userDAO.findByUserIdentification(loginid);
			if(ur!=null) {
				if(ur.getPassword().equals(password)) {
					
					return ur;
					
					
				}else
				{
					throw new UserExceptions("Invalid user");
				}
				
			}else {
				throw new UserExceptions("User not present");
			}
			
		}
	
	//ChangePassword
	public void changePassword(Long id,String oldPassword, String newPassword) throws UserExceptions {
		
		if(oldPassword.equals(newPassword)) {
			throw new UserExceptions("The old password and new password are same");
			
		}else {
			
		
		List<User> users = userDAO.findAll();
		
		for(User ur:users) {
				if(ur.getPassword().equals(oldPassword)) {
					ur.setPassword(newPassword);
					userDAO.save(ur);
				}
			}
		}
			
	}
	
	@Override
	public void removeUser(User user,Long id) throws UserExceptions{
		try {
			User currentUser = (userDAO.findById(id)).orElse(null);
			if(currentUser!=null) {
				userDAO.delete(currentUser);
			} else {
				throw new UserExceptions("No such matching user exists! ");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User findByEmail(String email){
		return userDAO.findByEmail(email);
	}
}


