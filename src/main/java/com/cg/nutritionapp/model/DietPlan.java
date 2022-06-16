package com.cg.nutritionapp.model;

import javax.persistence.*;

@Entity
@Table(name = "DietPlan")
public class DietPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="slots")
    private String slots;
    @Column(name="food_type")
    private String foodType;
    @Column(name="protein_ratio")
    private Double proteinRatio;
    @Column(name="fat_ratio")
    private Double fatRatio;
    @Column(name="carbs_ratio")
    private Double carbsRatio;
    @Column(name="total")
    private Double total;

    /**
     * default constructor for creating instance only.
     */

    @OneToOne()
	@JoinColumn(name="user_id")
	private User user;
    
    public DietPlan()
    {
    }

    public DietPlan( String slots, String foodType, double proteinRatio, double fatRatio,
                     double carbsRatio, double total){

        super();

        this.slots = slots;
        this.foodType = foodType;
        this.proteinRatio = proteinRatio;
        this.fatRatio = fatRatio;
        this.carbsRatio = carbsRatio;
        this.total = total;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public double getProteinRatio() {
        return proteinRatio;
    }

    public void setProteinRatio(double proteinRatio) {
        this.proteinRatio = proteinRatio;
    }

    public double getFatRatio() {
        return fatRatio;
    }

    public void setFatRatio(double fatRatio) {
        this.fatRatio = fatRatio;
    }

    public double getCarbsRatio() {
        return carbsRatio;
    }

    public void setCarbsRatio(double carbsRatio) {
        this.carbsRatio = carbsRatio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
    public String toString() {
        return "DietPlan [id=" + id +", slots=" + slots + ", foodType=" + foodType
                + ", proteinRatio=" + proteinRatio + ", fatRatio=" + fatRatio + ", carbsRatio=" + carbsRatio
                + ", total=" + total + "]";
    }

}
