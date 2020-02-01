package com.shopify.ShoppingBackend.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "TBL_PRODUCT")
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3592838233235966187L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String code;
	private String name;
	private String brand;
	@JsonIgnore
	private String description;
	@Column(name = "unit_Price")
	private double unitPrice;
	private Integer qunatity;

	@Column(name = "is_active")
	@JsonIgnore
	private boolean active;

	@Column(name = "category_Id")
	@JsonIgnore
	private Integer categoryId;

	@Column(name = "supplier_Id")
	@JsonIgnore
	private Integer supplierId;
	private Integer purchases;
	private Integer views;

	// default constructor
	public Product() {
		// Product will get unique id as soon as the product is created
		this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQunatity() {
		return qunatity;
	}

	public void setQunatity(Integer qunatity) {
		this.qunatity = qunatity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getPurchases() {
		return purchases;
	}

	public void setPurchases(Integer purchases) {
		this.purchases = purchases;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
