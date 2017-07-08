package com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity 
@Table (name = "inventory")
@Component
public class Inventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
		
	@ManyToOne 
	@JoinColumn(name="product_id",referencedColumnName="id")
	private Product product;
	
	@ManyToOne 
	@JoinColumn(name="supplier_id",referencedColumnName="user_id")
	private UserSupplier supplier;
	
	private String product_title;

	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProduct_title() {
		return product_title;
	}

	public void setProduct_title(String product_title) {
		this.product_title = product_title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public UserSupplier getSupplier() {
		return supplier;
	}

	public void setSupplier(UserSupplier supplier) {
		this.supplier = supplier;
	}
	
}
