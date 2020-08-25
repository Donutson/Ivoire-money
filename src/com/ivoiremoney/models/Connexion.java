package com.ivoiremoney.models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class décriant la structure d'un objet connexion à la db utilisant JDBC
 * @author Nelson
 *
 */
public abstract class Connexion {
	protected String url ;
	protected String user = "root";
	protected String passwd = "";
	protected static Connection conn;
	protected static String driver;

	protected Connexion(String driver) {
		Connexion.driver = driver;
		try {
			switch(Connexion.driver.toUpperCase()){
			case "MYSQL":
				Class.forName("com.mysql.jdbc.Driver");
				this.url = "jdbc:mysql://localhost:3306/Account";
				break;
			case "POSTGRESQL":
				Class.forName("org.postgresql.Driver");
				this.url = "jdbc:postgresql://localhost:5432/Account";
				break;
			}
			
			System.out.println("Driver O.K.");
			Connexion.conn = DriverManager.getConnection(this.url, this.user, this.passwd);
			System.out.println("Connexion effective !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
