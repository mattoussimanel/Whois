package com.example.demo.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity

public class Role implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idRole;
private String Description;

private String role;
//@ManyToMany
//private User user;
public int getIdRole() {
	return idRole;
}
public void setIdRole(int idRole) {
	this.idRole = idRole;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}


public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Role(int idRole, String description, String role) {
	super();
	this.idRole = idRole;
	Description = description;
	this.role = role;
}
public Role(String role) {
	super();
	this.role = role;
}
public Role() {
	super();
	// TODO Auto-generated constructor stub
}

	
	
}



