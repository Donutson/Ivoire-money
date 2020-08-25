package com.ivoiremoney.models;

import java.sql.Connection;

public class ConnexionSql extends Connexion {
	
	private ConnexionSql() {
		super("mysql");
	}
	
	
	public static Connection getInstance() {
		if(Connexion.conn == null) {
			ConnexionSql connexion = new ConnexionSql();
			ConnexionSql.conn = connexion.conn;
		}
		
		return ConnexionSql.conn;
	}

}
