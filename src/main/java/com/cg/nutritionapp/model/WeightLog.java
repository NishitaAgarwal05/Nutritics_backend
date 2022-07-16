package com.cg.nutritionapp.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="WeightLog")
public class WeightLog {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	/*
	 * Store your Weight Entry.
	 * Cannot be negative .
	 * Does work with decimal values.
	 */
	@Column(name = "weight")
	private Double weight;
	/*
	 * stores date of the creation of record.
	 * Does automatically from your device.
	 */
	@Column(name = "created_at")
	private LocalDate createdAt;
	/**
	 * Stores date of updation of record.
	 */
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	/*
	 * userid is the unique identification of user.
	 * Will be asked from user whenever they access any record.
	 */


	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	/**
	 * Provides initialization to module.
	 */
	public WeightLog() {
		super();
	}
	/**
	 * provides default values to the things user do not provide.
	 */
	public WeightLog(Double weight, LocalDate created_At, LocalDate updated_At) {
		
		super();
		this.weight = weight;
		this.createdAt = created_At;
		this.updatedAt = updated_At;

	}

	/**
	 * Below are getters and setters methods for getting and storing data.
	 * getters and setters are for weight,created_At,updated_At,user_Id. 
	 * @return
	 */
	public Long getId() {return id; }
	public void setId(Long id) {this.id = id; }
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDate getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * To String method to return all kind of  data in string format.
	 */
	@Override
	public String toString() {
		return "WeightLog [id="+id+", weight=" + weight + ", created_At=" + createdAt + ", updated_At=" + updatedAt +  "]";
	}
	
	
	
}
