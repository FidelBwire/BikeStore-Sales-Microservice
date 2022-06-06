package com.app.bikestore.sales.order_items.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.ws.rs.DefaultValue;

@Entity
@Table(name = "orderItems")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(nullable = false, updatable = false)
	private Long orderId;
	
	@Column(nullable = false, updatable = false)
	private Long ItemId;
	
	@NotEmpty
	@Column(nullable = false)
	private Long productId;
	
	@NotEmpty
	@Column(nullable = false)
	@DefaultValue(value = "1")
	private int quantity;
	
	@Column(nullable = false)
	private BigDecimal listPrice;
	
	@PositiveOrZero
	private BigDecimal discount;

	public OrderItem() { }

	public OrderItem(Long itemId, @NotEmpty Long orderId, @NotEmpty Long productId, @NotEmpty int quantity,
			@NotEmpty @Positive BigDecimal listPrice, @PositiveOrZero BigDecimal discount) {
		ItemId = itemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.listPrice = listPrice;
		this.discount = discount;
	}

	public Long getItemId() {
		return ItemId;
	}

	public void setItemId(Long itemId) {
		ItemId = itemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
}
