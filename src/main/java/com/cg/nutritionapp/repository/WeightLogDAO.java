package com.cg.nutritionapp.repository;


import java.sql.SQLException;
import java.util.List;

import com.cg.nutritionapp.model.WeightLog;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository

public interface WeightLogDAO extends JpaRepository<WeightLog,Long> {

	/**
	 *  To save all the value to weightlog.
	 */
	WeightLog save(WeightLog weightLog);
	/**
	 *   To display the values in weightlog.
	 */
	List<WeightLog> findAll()  ;
	/**
	 * 	To update values for weightLog.
	 */
	/**
	 *
	 * To delete your weight log.
	 */
	void delete(WeightLog weightLog) ;

}

