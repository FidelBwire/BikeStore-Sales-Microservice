package com.app.bikestore.sales.orders.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(nullable = false)
	private Long customerId;
	
	@NotEmpty
	@Column(nullable = false)
	@Min(value = 1)
	@Max(value = 4)
	private int orderStatus;
	
	@NotEmpty
	@Column(nullable = false)
	@PastOrPresent
	private Date orderDate;
	
	@NotEmpty
	@Column(nullable = false)
	@FutureOrPresent
	private Date requiredDate;
	
	@NotEmpty
	@PastOrPresent
	private Date shippedDate;
	
	@NotEmpty
	@Column(nullable = false)
	private Long storeId;
	
	@NotEmpty
	@Column(nullable = false)
	private Long staffId;
	
	public Order() { }

	public Order(Long id, @NotEmpty Long customerId, @NotEmpty @Min(1) @Max(4) int orderStatus,
			@NotEmpty @PastOrPresent Date orderDate, @NotEmpty @FutureOrPresent Date requiredDate,
			@NotEmpty @PastOrPresent Date shippedDate, @NotEmpty Long storeId, @NotEmpty Long staffId) {
		this.id = id;
		this.customerId = customerId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.storeId = storeId;
		this.staffId = staffId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	
}
