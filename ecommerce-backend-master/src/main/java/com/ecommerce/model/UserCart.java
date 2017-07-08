package com.ecommerce.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "user_cart")
@Component
public class UserCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne 
	@JoinColumn(name="product_id",referencedColumnName="id")
	private Product product;
	
	private int quantity;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date created_on=new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Version
    private Date updated_on;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "user_id")
	private UserCustomer customer;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public Date getUpdated_on() {
		return updated_on;
	}

	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}

	public UserCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(UserCustomer customer) {
		this.customer = customer;
	}

}
