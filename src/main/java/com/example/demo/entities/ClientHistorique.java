package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ClientHistorique implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nom;
private int telephone;
private String cin;
private String acctstatustype;
@Temporal(TemporalType.TIMESTAMP)
@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
private Date acctstarttime;
@Temporal(TemporalType.TIMESTAMP)
@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
private Date acctstoptime; 
private int acctsessiontime;
private String framedipaddress;
private int tel_adsl;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public int getTelephone() {
	return telephone;
}
public void setTelephone(int telephone) {
	this.telephone = telephone;
}
public String getCin() {
	return cin;
}
public void setCin(String cin) {
	this.cin = cin;
}
public String getAcctstatustype() {
	return acctstatustype;
}
public void setAcctstatustype(String acctstatustype) {
	this.acctstatustype = acctstatustype;
}
public Date getAcctstarttime() {
	return acctstarttime;
}
public void setAcctstarttime(Date acctstarttime) {
	this.acctstarttime = acctstarttime;
}
public Date getAcctstoptime() {
	return acctstoptime;
}
public void setAcctstoptime(Date acctstoptime) {
	this.acctstoptime = acctstoptime;
}
public int getAcctsessiontime() {
	return acctsessiontime;
}
public void setAcctsessiontime(int acctsessiontime) {
	this.acctsessiontime = acctsessiontime;
}
public String getFramedipaddress() {
	return framedipaddress;
}
public void setFramedipaddress(String framedipaddress) {
	this.framedipaddress = framedipaddress;
}
public int getTel_adsl() {
	return tel_adsl;
}
public void setTel_adsl(int tel_adsl) {
	this.tel_adsl = tel_adsl;
}
public ClientHistorique() {
	super();
	// TODO Auto-generated constructor stub
}
public ClientHistorique(int id, String nom, int telephone, String cin, String acctstatustype, Date acctstarttime,
		Date acctstoptime, int acctsessiontime, String framedipaddress, int tel_adsl) {
	super();
	this.id = id;
	this.nom = nom;
	this.telephone = telephone;
	this.cin = cin;
	this.acctstatustype = acctstatustype;
	this.acctstarttime = acctstarttime;
	this.acctstoptime = acctstoptime;
	this.acctsessiontime = acctsessiontime;
	this.framedipaddress = framedipaddress;
	this.tel_adsl = tel_adsl;
}

}
