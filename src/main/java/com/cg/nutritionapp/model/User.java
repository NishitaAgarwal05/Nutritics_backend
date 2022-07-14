package com.cg.nutritionapp.model;

import javax.persistence.*;
import java.util.List;

/**
 * A model class used to hold and transfer attribute values from one layer to other.
 * @author 
 *
 */
@Entity
@Table(name="users")
public class User {
	/**
	 * id is used for storing automatically generated id
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long userId;
	// /**
	//  * userIdentification is unique and is String
	//  */
	// @Column(name="user_identification",unique=true)
	// private String userIdentification;
	/**
	 * name is of type String and used to store user's name
	 */
	@Column(name="name")
	private String  name;
	/**
	 * contact is of type String and store user contact details
	 */
	@Column(name="contact")
	private String contact;
	/**
	 * gender is of type String and stores gender value
	 */
	@Column(name="gender")
	private String gender;
	/**
	 * dob is Date of Birth and is of type String
	 */
	@Column(name="dob")
	private String dob;
	/**
	 * photo is used to store filename of with jpg/png extension
	 */
	// @Column(name="photo")
	// private String photo;
	/**
	 * email stores email of user
	 */
	@Column(name="email")
	private String email;
	/**
	 * Role specifies whether a user is customer or a dietitian 
	 */
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "role_id")
	private Role role;
	/**
	 * status defines if any user is active or blocked
	 */
	@Column(name="status")
	private String status;
	/**
	 * weight is of type double and store weight of user
	 */
	
	@Column(name="weight")
	private Double weight;

	/**
	 * weightLogList is the list of weight logs of a specific user
	 */

	// @OneToMany(mappedBy="user")
	// private List<WeightLog> weightLogList;

	/**
	 * paymentList is the list of payments done by a specific user
	 */
	
	// @OneToMany(mappedBy="user")
	// private List<Payment> paymentList;

	/**
	 * nutritionPlan defines how the nutrition plan of the specific users is
	 */
	@OneToOne(mappedBy = "user")
	private NutritionPlan nutritionPlan;
	
	// @OneToOne(mappedBy = "user")
	// private  DietPlan dietPlan;

	/**
	 * height is also of type double and stores height
	 */
	@Column(name="height")
	private Double height;

	/**
	 * diateryOrientation defines how the diet plan of the specific users is
	 */


	/**
	 * intensity is a number which defines the ability to do workout on the scale of 1-10
	 */
	
	
	@Column(name="intensity")
	private Double intensity;
	/**
	 * goal defines the specific goal set by user or dietitian 
	 */
	@Column(name="goal")
	private String goal;
	/**
	 * number of hours a person can workout
	 */
	@Column(name="work_out_time")
	private String workOutTime;
	/**
	 * time by which user wakes up
	 */
	@Column(name="wake_up_time")
	private String wakeUpTime;
	/**
	 * time by which user goes to sleep
	 */
	@Column(name="sleep_time")
	private String sleepTime;
	/**
	 * medical condition defines if a user is having any medical conditions or not
	 */
	@Column(name="medical_condition")
	private String medicalCondition;
	/**
	 * this is a String type stores value if a person is allergic to something
	 */
	@Column(name="allergic_to")
	private String allergicTo;
	/**
	 * loginNmae is the login name specified by user
	 */
	// @Column(name="login_name")
	// private String loginName;
	/**
	 * password is the password set by user;
	 */
	@Column(name="password",unique=true)
	private String password;
	
	@Column(name="diateryOrientation")
	private Long diateryOrientation;


	/**
	 * default Constructor
	 */
	public User() {
		super();
	}

	/**
	 * Constructor with parameters excluding id
	 * @param userIdentification
	 * @param name
	 * @param contact
	 * @param gender
	 * @param dob
	 * @param photo
	 * @param email
	 * @param role
	 * @param status
	 * @param weight
	 * @param height
	 * @param diateryOrientation
	 * @param intensity
	 * @param goal
	 * @param workOutTime
	 * @param wakeUpTime
	 * @param sleepTime
	 * @param medicalCondition
	 * @param allergicTo
	 * @param loginName
	 * @param password
	 */
	public User(/*Long userId, String userIdentification,*/ String name, String contact, String gender, String dob, /*String photo,*/
			String email, Role role, String status, Double weight, Double height, Long diateryOrientation,
			Double intensity, String goal, String workOutTime, String wakeUpTime, String sleepTime,
			String medicalCondition, String allergicTo, /*String loginName,*/ String password) {
		super();
		// this.userIdentification = userIdentification;
		this.name = name;
		this.contact = contact;
		this.gender = gender;
		this.dob = dob;
		// this.photo = photo;
		this.email = email;
		this.role = role;
		this.status = status;
		this.weight = weight;
		this.height = height;
		this.diateryOrientation = diateryOrientation;
		this.intensity = intensity;
		this.goal = goal;
		this.workOutTime = workOutTime;
		this.wakeUpTime = wakeUpTime;
		this.sleepTime = sleepTime;
		this.medicalCondition = medicalCondition;
		this.allergicTo = allergicTo;
		// this.loginName = loginName;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	// public String getUserIdentification() {
	// 	return userIdentification;
	// }
	// public void setUserIdentification(String userIdentification) {
	// 	this.userIdentification = userIdentification;
	// }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	// public String getPhoto() {
	// 	return photo;
	// }
	// public void setPhoto(String photo) {
	// 	this.photo = photo;
	// }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Long getDiateryOrientation() {
		return diateryOrientation;
	}
	public void setDiateryOrientation(Long diateryOrientation) {
		this.diateryOrientation = diateryOrientation;
	}
	public Double getIntensity() {
		return intensity;
	}
	public void setIntensity(Double intensity) {
		this.intensity = intensity;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getWorkOutTime() {
		return workOutTime;
	}
	public void setWorkOutTime(String workOutTime) {
		this.workOutTime = workOutTime;
	}
	public String getWakeUpTime() {
		return wakeUpTime;
	}
	public void setWakeUpTime(String wakeUpTime) {
		this.wakeUpTime = wakeUpTime;
	}
	public String getSleepTime() {
		return sleepTime;
	}
	public void setSleepTime(String sleepTime) {
		this.sleepTime = sleepTime;
	}
	public String getMedicalCondition() {
		return medicalCondition;
	}
	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}
	public String getAllergicTo() {
		return allergicTo;
	}
	public void setAllergicTo(String allergicTo) {
		this.allergicTo = allergicTo;
	}
	// public String getLoginName() {
	// 	return loginName;
	// }
	// public void setLoginName(String loginName) {
	// 	this.loginName = loginName;
	// }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

/*	public List<WeightLog> getWeightLogList() {
		return weightLogList;
	}

	public void setWeightLogList(List<WeightLog> weightLogList) {
		this.weightLogList = weightLogList;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public NutritionPlan getNutritionPlan() {
		return nutritionPlan;
	}

	public void setNutritionPlan(NutritionPlan nutritionPlan) {
		this.nutritionPlan = nutritionPlan;
	}
*/
	@Override
	public String toString() {
		return "User [id=" + userId + /*", userIdentification=" + userIdentification + */", name=" + name + ", contact="
				+ contact + /*", gender=" + gender + ", dob=" + dob + ", photo=" + photo + */", email=" + email + ", role="
				+ role + /*", status=" + status + ", weight=" + weight + ", height=" + height + ", diateryOrientation="
				+ diateryOrientation + ", intensity=" + intensity + ", goal=" + goal + ", workOutTime=" + workOutTime
				+ ", wakeUpTime=" + wakeUpTime + ", sleepTime=" + sleepTime + ", medicalCondition=" + medicalCondition
				+ ", allergicTo=" + allergicTo + ", loginName=" + loginName + */", password=" + password + "]";
	}

}

