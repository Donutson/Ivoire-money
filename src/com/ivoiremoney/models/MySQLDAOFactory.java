package com.ivoiremoney.models;

import java.sql.Connection;

public class MySQLDAOFactory extends DAOFactory{
	
	protected static final Connection conn =
			ConnexionSql.getInstance();
	
	@Override
	public UserDAO getUserDAO() {

		return new UserDAO(MySQLDAOFactory.conn);
	}

}
