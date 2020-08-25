package com.ivoiremoney.beans;

import com.ivoiremoney.models.DAOFactory;
import com.ivoiremoney.models.MySQLDAOFactory;
import com.ivoiremoney.models.UserDAO;

public class FormTransfert {
	/**
	 * class pour le traitement des infos du formulaire de transfert
	 */
	
	private String idErrorMessage;
	private String amountErrorMessage;
	private String successMessage;
	private User dest;
	private User user;
	private boolean valid = true;
	private double solde;
	
	public FormTransfert(User user,User dest, double solde) {
		this.setUser(user);
		this.setSolde(solde);
		this.check(dest);
	}
	
	
	private void check(User dest) {
		/**
		 * Vérifie l'existence du destinataire et la possibilité de l'utilisateur à effectuer le transfert
		 * @param dest: destinataire du transfert
		 */
		
		MySQLDAOFactory factory = (MySQLDAOFactory) DAOFactory.getFactory(DAOFactory.MySQL_DAO_FACTORY);
		UserDAO userdao = factory.getUserDAO();
		
		// on s'assure que l'utilisateur ne se transfert pas d'argent à lui même
		if(this.getUser().getPhone() != dest.getPhone()) {
			//existence du destinataire
			User user1 = userdao.find("identifiant", dest.getId());
			if(user1 == null) {
				this.setIdErrorMessage("Le destinataire ne possède pas de compte");
				this.setValid(false);
			}else {
				this.setDest(user1);
			}
			
			//l'utilisateur possède assez d'argent pour le transfert
			if((this.getUser().getSolde()- this.getSolde())<0) {
				this.setAmountErrorMessage("Vous n'avez pas assez d'argent pour effectuer ce transfert");
				this.setValid(false);
			}
		}else {
			this.setIdErrorMessage("Vous ne pouvez pas vous transferez d'argent à vous même");
			this.setValid(false);
		}
			
	}
	
	public void makeTransfer() {
		/**
		 * effectue le transfert d'argent
		 */
		
		// on effectue le transfert quand il n'y a pas d'erreur
		if(this.isValid()) {
			MySQLDAOFactory factory = (MySQLDAOFactory) DAOFactory.getFactory(DAOFactory.MySQL_DAO_FACTORY);
			UserDAO userdao = factory.getUserDAO();
			
			this.getUser().setSolde(this.getUser().getSolde()- this.getSolde());
			this.getDest().setSolde(this.getDest().getSolde()+ this.getSolde());
			
			userdao.startTransaction();
			userdao.update(this.getUser(), "solde");
			userdao.update(this.getDest(), "solde");
			userdao.commit();
			this.setSuccessMessage("Transfert réussie");
		}else {
			this.setSuccessMessage("Le transfert n'a pu être éffectué!!");
		}
			
		
	}

	public String getIdErrorMessage() {
		return idErrorMessage;
	}

	private void setIdErrorMessage(String errorMessage) {
		this.idErrorMessage = errorMessage;
	}

	public User getDest() {
		return dest;
	}

	private void setDest(User dest) {
		this.dest = dest;
	}

	public User getUser() {
		return user;
	}

	private void setUser(User user) {
		this.user = user;
	}

	private double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getAmountErrorMessage() {
		return amountErrorMessage;
	}

	public void setAmountErrorMessage(String amountErrorMessage) {
		this.amountErrorMessage = amountErrorMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	private void setSuccessMessage(String succesMessage) {
		this.successMessage = succesMessage;
	}


	private boolean isValid() {
		return valid;
	}


	private void setValid(boolean valid) {
		this.valid = valid;
	}
}
