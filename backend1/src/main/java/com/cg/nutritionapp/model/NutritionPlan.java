package com.cg.nutritionapp.model;


import javax.persistence.*;


import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "NutritionPlan")
public class NutritionPlan {
	/**
	 * ID of the Nutrition Plan
	 * ID is auto-generated
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Name of the Nutrition Plan
	 */
	@Column(name="name",nullable = false)
	private String name;
	
	/**
	 * Description of the Plan
	 */
	@Column(name="plan_description",nullable = false)
	private String planDescription;
	
	/**
	 * Date of creation of the Plan
	 */
	@Column(name="created_at", nullable = false)
	private Date created_At;
	
	/**
	 * Date of updation of Plan
	 */
	@Column(name="updated_at", nullable = false)
	private Date updated_At;
	
	/**
	 * Price of the Plan
	 */
	@Column(name="price", nullable = false)
	private Long price;
	
	@OneToOne()
	@JoinColumn(name="user_id")
	private User user;

	public NutritionPlan()
	{
	}

	public NutritionPlan(String name, String planDescription, Date created_At, Date updated_At, Long price) 
	{
		super(); 
		this.name = name;
		this.planDescription = planDescription; 
		this.created_At = created_At;
		this.updated_At = updated_At; 
		this.price = price;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "NutritionPlan [name=" + name + ", planDescription=" + planDescription + ", created_At=" + created_At
				+ ", updated_At=" + updated_At + ", price=" + price + "]";
	}
	
}
