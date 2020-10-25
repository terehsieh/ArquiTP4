package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduct;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int price;

	@Column
	private String details;

	@Column
	private Integer stock;
	
	@ManyToMany
	@JsonIgnore
	private List<Bill> bills; // facturas
	public Product() {
super();
	}
	public Product(String name, int price, String details, Integer stock, List<Bill> bills) {
		super();
		this.name = name;
		this.price = price;
		this.details = details;
		this.stock = stock;
		this.bills = bills;
	}
	

}
