package com.tastebuzz.main.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="recipes")
public class Recipe {
	
	//attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, message = "Name of recipe is must be at least 3 characters")
	private String nor;
	
	@Size(min = 5, message = "Description must be at least 10 characters")
	private String description;
	
	@NotNull(message = "Ingredients are required, cannot be blank")
	@Size(min = 25, message ="Ingredients are required")
	private String ingredients;
	
	@NotNull(message = "Directions are required, cannot be blank")
	@Size(min = 25, message ="Directions are required")
	private String directions;
	
	@Size(min = 1, message = "Prep time is required")
	private String preptime;
	
	@Size(min = 1, message = "Cook time is required")
	private String cooktime;
	
	@Size(min = 1, message = "Serving size is required")
	private String servings;
	
	private String yield;
	
	private String notes;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//relationships
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User creator;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "likedBy_id")
    private User likedBy;
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	//constructor

	public Recipe() {
	}

	public Long getId() {
		return id;
	}

	public String getNor() {
		return nor;
	}

	public String getDescription() {
		return description;
	}

	public String getIngredients() {
		return ingredients;
	}

	public String getDirections() {
		return directions;
	}

	public String getPreptime() {
		return preptime;
	}

	public String getCooktime() {
		return cooktime;
	}

	public String getServings() {
		return servings;
	}

	public String getYield() {
		return yield;
	}

	public String getNotes() {
		return notes;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public User getCreator() {
		return creator;
	}

	public User getLikedBy() {
		return likedBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNor(String nor) {
		this.nor = nor;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public void setPreptime(String preptime) {
		this.preptime = preptime;
	}

	public void setCooktime(String cooktime) {
		this.cooktime = cooktime;
	}

	public void setServings(String servings) {
		this.servings = servings;
	}

	public void setYield(String yield) {
		this.yield = yield;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void setLikedBy(User likedBy) {
		this.likedBy = likedBy;
	}
	
}
