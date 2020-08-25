package com.ivoiremoney.beans;

public class User {
	/**
	 * class rprésentant un utilisateur
	 */
	
	private String nom = "Jhon";
	private String prenom = "Connor";
	private String mail = "jhon@yahoo.com";
	private int phone = 01010101;
	private String id = "Jhon";
	private String pass = "terminator";
	private double solde = 30000;
	private String photo;
	
	
	public User(String nom, String prenom, String mail, int phone, String id, String pass) {
		this.dry(nom, prenom, mail, phone, id, pass);
	}
	
	public User(String nom, String prenom, String mail, String phone, String id, String pass, String photo) {
		this.dry(nom, prenom, mail, phone, id, pass, photo);
	}
	
	public User(String nom, String prenom, String mail, int phone, String id, String pass, double solde) {
		this.dry(nom, prenom, mail, phone, id, pass, solde);
	}
	
	public User(String id, String pass) {
		this.setId(id);
		this.setPass(pass);
	}
	
	
	public User(String id) {
		this.setId(id);
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public void setPhone(String phone) {
		try {
			this.phone = Integer.parseInt(phone);
		} catch (Exception e) {
			// TODO: handle exception
			this.phone = 0;
		}
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	private void dry(String nom, String prenom, String mail, int phone, String id, String pass) {
		
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setMail(mail);
		this.setPhone(phone);
		this.setId(id);
		this.setPass(pass);
	}
	
	private void dry(String nom, String prenom, String mail, String phone, String id, String pass, String photo) {
		
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setMail(mail);
		this.setPhone(phone);
		this.setId(id);
		this.setPass(pass);
		this.setPhoto(photo);
	}
	
	private void dry(String nom, String prenom, String mail, int phone, String id, String pass, double solde) {
		
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setMail(mail);
		this.setPhone(phone);
		this.setId(id);
		this.setPass(pass);
		this.setSolde(solde);
	}

}
