package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Bill {
//	implementar serializable

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // unica
	private Integer idBill;
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
	private Date date;
	@ManyToOne
	private Client client; // un cliente tiene varias facturas

//lista de prodcutos
	@ManyToMany
	private List<Product> products;

	public Bill() {
		super();
	}

	public Bill(Date fecha, Client client, List<Product> products) {
		super();
		this.date = fecha;
		this.client = client;
		this.products = products;
	}

}
