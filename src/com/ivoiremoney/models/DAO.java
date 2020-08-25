package com.ivoiremoney.models;

import java.sql.Connection;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn) {
		this.connect = conn;
	}

	/**
	 * M�thode de cr�ation
	 * 
	 * @param obj: l'objet � cr�er
	 * @return boolean
	 */
	public abstract boolean create(T obj);

	/**
	 * M�thode pour effacer
	 * 
	 * @param obj: l'objet � �ffacerr
	 * @return boolean
	 */
	public abstract boolean delete(T obj);

	/**
	 * M�thode de mise � jour
	 * 
	 * @param obj: l'objet � mettre � jour
	 * @return boolean
	 */
	public abstract boolean update(T obj, String att);

	/**
	 * M�thode de recherche des informations
	 * 
	 * @param id: l'id de l'objet � rechercher
	 * @return T
	 */
	public abstract T find(int id);
}
