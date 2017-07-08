package com.ecommerce.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "orders")
@Component
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String order_no;
	
	private double total_amount;

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "user_id")
	private UserCustomer customer;
	
	private String description;
	
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date created_on=new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Version
    private Date updated_on;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		if(order_no == null){
		UUID uid = UUID.fromString("58D5E212-165B-4CA0-909B-C86B9CEE0111");
		System.out.println("setOrder_no -> " + uid.toString());
		this.order_no = "ord" + uid.randomUUID().toString().substring(0, 7);
		} else {
			this.order_no = order_no;
		}
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
