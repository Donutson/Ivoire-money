package com.ivoiremoney.beans;

import com.ivoiremoney.models.DAOFactory;
import com.ivoiremoney.models.MySQLDAOFactory;
import com.ivoiremoney.models.UserDAO;

public class Form {
	/**
	 * class pour la gestion des infos du formulaire d'inscription
	 */
	
	/**
	 * Messages d'erreur
	 */
	
	private String phoneMessage;
	private String confirmMessage;
	private String idMessage;
	private String mailMessage;
	
	/**
	 * Permet de savoir si le formulaire est valide
	 */
	
	private boolean valid = true;
	
	public Form(User user, String confirm) {
		this.setConfirmMessage(confirm);
		this.checkPhone(user.getPhone());
		this.checkConfirm(user.getPass());
		this.checkUserExist(user);
	}

	public String getPhoneMessage() {
		return phoneMessage;
	}

	public void setPhoneMessage(String phoneMessage) {
		this.phoneMessage = phoneMessage;
	}
	
	/**
	 * Vérifie la validité du numéro de téléphone
	 * @param phone: numéro de téléphone du client
	 */
	private void checkPhone(long phone) {
		if(Long.toString(phone).length() != 8) {
			phoneMessage = "Veuillez saisir un numéro à 8 chiffres";
			this.setValid(false);
		}
	}
	
	/**
	 * Vérifie que le mot de passe ressaisit correspond au précédent
	 * @param pass: mot de passe
	 */
	private void checkConfirm(String pass) {
		if(!confirmMessage.equals(pass)) {
			this.setConfirmMessage("Le mot de passe ne correspond pas");
			this.setValid(false);
		}else {
			this.setConfirmMessage(null);
		}
	}
	
	/**
	 * Vérifie si l'utilisateur n'existe pas déjà
	 * @param user: l'utisateur qu'on veut vérifier
	 */
	public void checkUserExist(User user) {
		MySQLDAOFactory factory = (MySQLDAOFactory) DAOFactory.getFactory(DAOFactory.MySQL_DAO_FACTORY);
		UserDAO userdao = factory.getUserDAO();
		
		//Unicité du téléphone
		User user1 = userdao.find(user.getPhone());
		if(user1 != null) {
			this.setPhoneMessage("Ce numéro est déjà utilisé");
			this.setValid(false);
		}
		
		//Unicité de l'identifiant
		user1 = userdao.find("identifiant", user.getId());
		if(user1 != null) {
			this.setIdMessage("Cet utilisteur existe déjà");
			this.setValid(false);
		}
		
		//Unicité du mail
		user1 = userdao.find("mail", user.getMail());
		if(user1 != null){
			this.setMailMessage("Cet mail est déjà utiliser par un utilisteur");
			this.setValid(false);
		}
	}

	public String getConfirmMessage() {
		return confirmMessage;
	}

	public void setConfirmMessage(String confirmMessage) {
		this.confirmMessage = confirmMessage;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public String getMailMessage() {
		return mailMessage;
	}

	public void setMailMessage(String mailMessage) {
		this.mailMessage = mailMessage;
	}

}
