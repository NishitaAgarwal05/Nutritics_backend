package com.cg.nutritionapp.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payments")
public class Payment implements Serializable{
	/**
	 * This field represents id of payment
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/**
	 * This field represents amount of payment
	 */
	@Column(name="payment")
	private Double payment;
	/**
	 * This field represents discount amount for payment
	 * never be negative
	 * In case if user enter negative payment, he should throw with PaymentException
	 */
	// @Column(name="discount")
	// private Double discount;
	/**
	 * This field represents Date of payment
	 */
	@Column(name="created_at")
	//@Temporal(TemporalType.DATE)
	private LocalDate created_At;
	/**
	 * This field represents Updated date of payment
	 */
	@Column(name="updated_at")
	//@Temporal(TemporalType.DATE)
	private LocalDate updated_At;
	/**
	 * This field represents id of user for which payment is happening
	 */
//	@Column(name="user_id")
//	private String userId;
	/**
	 * This field represents id of plan which user chose
	 */
	@Column(name="planId")
	private long planId;


	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;

	public Payment() {
		
	}

	public Payment(Double payment,/*  Double discount,*/ LocalDate created_At, LocalDate updated_At,
			long planId) {
		super();
		this.payment = payment;
		// this.discount = discount;
		this.created_At = created_At;
		this.updated_At = updated_At;
		
		this.planId = planId;
		
	}

	public Long getId() {
		return id;
	}

	public Double getPayment() {
		return payment;
	}

	// public Double getDiscount() {
	// 	return discount;
	// }

	public LocalDate getCreated_At() {
		return created_At;
	}

	public LocalDate getUpdated_At() {
		return updated_At;
	}

//	public String getUserId() {
//		return userId;
//	}

	public long getPlanId() {
		return planId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	// public void setDiscount(Double discount) {
	// 	this.discount = discount;
	// }

	public void setCreated_At(LocalDate created_At) {
		this.created_At = created_At;
	}

	public void setUpdated_At(LocalDate updated_At) {
		this.updated_At = updated_At;
	}

//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public void setPlanId(long planId) {
		this.planId = planId;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Payment [payment=" + payment + /*", discount=" + discount + */", created_At=" + created_At + ", updated_At="
				+ updated_At +", planId=" + planId + "]";
	}
	
}
