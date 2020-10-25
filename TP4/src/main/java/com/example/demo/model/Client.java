package com.example.demo.model;

import lombok.Data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idClient;
	@Column(nullable = false)
	private Long dni;
	@Column
	private String name;
	@Column
	private String surname;
//	@ManyToOne
//	private Address address;

	public Client() {
		super();
	}



//	public Client(int idClient, Integer dni, String name, String surname, Address address) {
//		super();
//		this.idClient = idClient;
//		this.dni = dni;
//		this.name = name;
//		this.surname = surname;
//		this.address = address;
//	}


	
	public Client(Long dni, String name, String surname) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
	}

//FUNCIONES
	@OneToMany(mappedBy="client")
	@JsonIgnore
	private List<Bill> compra;
	
	
	
//	GETTERS AND SETTERS
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long id) {
		this.dni = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
}
