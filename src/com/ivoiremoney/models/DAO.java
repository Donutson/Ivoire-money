package com.ivoiremoney.models;

import java.sql.Connection;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn) {
		this.connect = conn;
	}

	/**
	 * Méthode de création
	 * 
	 * @param obj: l'objet à créer
	 * @return boolean
	 */
	public abstract boolean create(T obj);

	/**
	 * Méthode pour effacer
	 * 
	 * @param obj: l'objet à éffacerr
	 * @return boolean
	 */
	public abstract boolean delete(T obj);

	/**
	 * Méthode de mise à jour
	 * 
	 * @param obj: l'objet à mettre à jour
	 * @return boolean
	 */
	public abstract boolean update(T obj, String att);

	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id: l'id de l'objet à rechercher
	 * @return T
	 */
	public abstract T find(int id);
}
