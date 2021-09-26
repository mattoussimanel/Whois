package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GeneratorType;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	@Column(name = "Nom")
	private String nom ;
	@Column(name = "Telephone")
	private String telephone;
	@Column(name = "Login")
	private String login;
	@Column(name = "Attribute")
	private String attribute;
	@Column(name = "Op")
	private String op;
	@Column(name = "Value")
	private String value;
	@Column(name = "Ipadress")
	private String ipadress;
	@Column(name = "Reply")
	private String reply;
	@Column(name = "Iproute")
	private String iproute;
	@Column(name = "Adresse")
	private String adresse;
	@Column(name = "Ville")
	private String ville;
	@Column(name = "Actif")
	private int actif;
	@Column(name = "Resadm_txt")
	private String resadm_txt;
	@Column(name = "Observation")
	private String observation; 
	@Column(name = "Cin")
	private String cin;
	@Column(name = "Groupname")
	private String groupname;
	@Column(name = "Debit")
	private String debit;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getIpadress() {
		return ipadress;
	}
	public void setIpadress(String ipadress) {
		this.ipadress = ipadress;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getIproute() {
		return iproute;
	}
	public void setIproute(String iproute) {
		this.iproute = iproute;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getActif() {
		return actif;
	}
	public void setActif(int actif) {
		this.actif = actif;
	}
	public String getResadm_txt() {
		return resadm_txt;
	}
	public void setResadm_txt(String resadm_txt) {
		this.resadm_txt = resadm_txt;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", telephone=" + telephone + ", login=" + login + ", attribute="
				+ attribute + ", op=" + op + ", value=" + value + ", ipadress=" + ipadress + ", reply=" + reply
				+ ", iproute=" + iproute + ", adresse=" + adresse + ", ville=" + ville + ", actif=" + actif
				+ ", resadm_txt=" + resadm_txt + ", observation=" + observation + ", cin=" + cin + ", groupname="
				+ groupname + ", debit=" + debit + ", image=" + image + "]";
	}
	public Client(int id, String nom, String telephone, String login, String attribute, String op, String value,
			String ipadress, String reply, String iproute, String adresse, String ville, int actif, String resadm_txt,
			String observation, String cin, String groupname, String debit, String image) {
		super();
		this.id = id;
		this.nom = nom;
		this.telephone = telephone;
		this.login = login;
		this.attribute = attribute;
		this.op = op;
		this.value = value;
		this.ipadress = ipadress;
		this.reply = reply;
		this.iproute = iproute;
		this.adresse = adresse;
		this.ville = ville;
		this.actif = actif;
		this.resadm_txt = resadm_txt;
		this.observation = observation;
		this.cin = cin;
		this.groupname = groupname;
		this.debit = debit;
		this.image = image;
	}
	public Client() {
		super();
		
	}
	

}


