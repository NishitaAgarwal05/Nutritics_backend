package com.cg.nutritionapp.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cg.nutritionapp.model.User;

public abstract class UserDAOImpl implements UserDAO{

	
	   private List<User> listOfUsers;

	    @Autowired
	    private UserDAO userDAO;    //DAO object

	    public UserDAOImpl(){
	    	
	    }

	    public User save(User user){    //Save User
	    	listOfUsers.add(user);
	        return user;
	    }
	
	    public List<User> findAll(){     //Find all list of Users
	    	
	        return listOfUsers;
	    }
	   
	   public void delete(User user){
	    	userDAO.delete(user);
	    }
	}
	
	
