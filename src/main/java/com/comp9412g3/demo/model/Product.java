package com.comp9412g3.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*; // for Spring Boot 3

@Entity
@Table(name = "products")
public class Product {

	@Id
	@SequenceGenerator(name = "productId", sequenceName = "productId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productId")
	private long productId;

	@Column(name = "productName")
	private String productName;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private double price;
	// private Long id;
	// private String description;
	// private double price;

	// @JsonProperty("product_id") Long productId,

	public Product(){

	}

	public Product(@JsonProperty("product_name") String productName, @JsonProperty("description") String description,
			@JsonProperty("price") double price) {
		// this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
