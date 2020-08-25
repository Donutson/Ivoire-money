package com.ivoiremoney.models;

public abstract class DAOFactory {

	public static final int MySQL_DAO_FACTORY = 0;
	public static final int Postgre_DAO_FACTORY = 1;

	public abstract UserDAO getUserDAO();

	public static DAOFactory getFactory(int type) {
		switch (type) {
		case MySQL_DAO_FACTORY:
			return new MySQLDAOFactory();
		case Postgre_DAO_FACTORY:
			return new PostgreDAOFactory();
		default:
			return null;
		}
	}
}
