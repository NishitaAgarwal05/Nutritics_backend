package com.cg.nutritionapp.repository;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
	    
	   public User findByUserIdentification(String userIdentification) {
		   
		   for(User ur:listOfUsers) {
			   if(ur.getUserIdentification().equals(userIdentification)) {
				   return ur;
			   }
		   }
		   return null;
		   
	   }
	   
	   public void delete(User user){
	    	userDAO.delete(user);
	    }
	}
	
	
