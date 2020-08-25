package com.ivoiremoney.beans;

import com.ivoiremoney.models.DAOFactory;
import com.ivoiremoney.models.MySQLDAOFactory;
import com.ivoiremoney.models.UserDAO;

/**
 * class pour le traitement des infos du formulaire de connexion
 */
public class FormConnect {	
	
	private String errorMessage;
	private boolean valid = true;
	private User puser = null;
	
	public FormConnect(User user) {
		this.checkUserExist(user);
	}

	private void checkUserExist(User user) {
		/**
		 * Vérifie l'exitence d'un utilisateur
		 * @param user: l'utilisateur dont on vérifie l'existence
		 */
		MySQLDAOFactory factory = (MySQLDAOFactory) DAOFactory.getFactory(DAOFactory.MySQL_DAO_FACTORY);
		UserDAO userdao = factory.getUserDAO();
		
		//récupération de l'utilisateur réchercher, vaut null s'il  n'existe pas
		User user1 = userdao.find("identifiant", user.getId());
		
		//on vérifie que l'user récupéré existe et correspond à l'utilisateur entré en paramètre
		if(user1 == null || !user1.getPass().equals(user.getPass())) {
			this.setErrorMessage("Cet utilisateur n'existe pas");
			this.setValid(false);
		}else {
			this.setPuser(user1);
		}
		
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public User getPuser() {
		return puser;
	}


	private void setPuser(User puser) {
		this.puser = puser;
	}
}
