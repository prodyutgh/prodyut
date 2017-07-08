package com.ecommerce.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.web;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity 
@Table (name = "products")
@Component
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;

    @NotEmpty(message = "The product name must not be empty")

	private String name;
	private String type;
	private String description;
	
    @Min(value = 0, message = "The product price must not be less then zero")
 
	private double price;
    @Min(value = 0, message = "The product unit must not be less then zero")

	private int quantity;
	private String image_name;
	
	@Transient
	private MultipartFile file;
	
	@ManyToOne 
	@JoinColumn(name="supplier_id",referencedColumnName="id")
	private UserSupplier supplier;
	
	@ManyToOne 
	@JoinColumn(name="product_category_id",referencedColumnName="id")
	private ProductCategory productCategory;
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public UserSupplier getSupplier() {
		return supplier;
	}
	public void setSupplier(UserSupplier supplier) {
		this.supplier = supplier;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage_name() {
		return image_name;
	}
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
