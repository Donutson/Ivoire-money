package com.ivoiremoney.models;

import java.sql.Connection;

public class ConnexionPostgre extends Connexion {

	private ConnexionPostgre() {
		super("postgresql");
	}
	
	public static Connection getInstance() {
		if(ConnexionPostgre.conn == null) {
			new ConnexionPostgre();
		}
		
		return ConnexionPostgre.conn;
	}
}
