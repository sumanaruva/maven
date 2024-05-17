package com.lenskart.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "userstable")
@Data
@Inheritance
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String role;

	private String name;
	private String email;
	private Long number;
	private String address;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private Cart cart;



}
