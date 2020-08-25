package com.ivoiremoney.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ivoiremoney.beans.User;

public class UserDAO extends DAO<User> {

	public UserDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(User user) {
		PreparedStatement stm = null;
		boolean issuccess = false;

		try {
			stm = this.connect.prepareStatement("INSERT INTO Infos(nom," + "prenom," + "mail," + "phone,"
					+ "identifiant," + "password," + "solde) VALUES(?, ?, ?, ?, ?, ?, ?)");

			stm.setString(1, user.getNom());
			stm.setString(2, user.getPrenom());
			stm.setString(3, user.getMail());
			stm.setInt(4, user.getPhone());
			stm.setString(5, user.getId());
			stm.setString(6, user.getPass());
			stm.setDouble(7, user.getSolde());

			issuccess = Boolean.parseBoolean(Integer.toString(stm.executeUpdate()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stm != null)
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return issuccess;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean update(User user, String att) {
		PreparedStatement stm = null;
		int result = 0;
		try {
			String query = "UPDATE Infos SET "+att+"=? WHERE identifiant=?";
			stm = this.connect.prepareStatement(query);
			switch(att) {
				case "solde":
					stm.setDouble(1, user.getSolde());
					break;
			}
			
			stm.setString(2, user.getId());
			result = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (stm != null)
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result == 1;
	}

	@Override
	public User find(int phone) {
		User user = null;
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			stm = this.connect.prepareStatement("SELECT * FROM Infos WHERE phone=?");
			stm.setInt(1, phone);
			result = stm.executeQuery();
			boolean notEmpty = result.next();
			
			if(notEmpty) {
				user = new User(result.getString("nom"), 
						result.getString("prenom"), 
						result.getString("mail"),
						result.getInt("phone"), 
						result.getString("identifiant"), 
						result.getString("password"),
						result.getDouble("solde"));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible de récupérer les données");
		} finally {

			if (result != null)
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stm != null)
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return user;
	}
	
	public User find(String attribute, Object value) {
		User user = null;
		PreparedStatement stm = null;
		ResultSet result = null;

		try {
			String query = "SELECT * FROM Infos WHERE "+attribute+"=?";
			stm = this.connect.prepareStatement(query);
			stm.setObject(1, value);
			result = stm.executeQuery();
			boolean notEmpty = result.next();
			
			if(notEmpty) {
				
				user = new User(result.getString("nom"), 
						result.getString("prenom"), 
						result.getString("mail"),
						result.getInt("phone"), 
						result.getString("identifiant"), 
						result.getString("password"),
						result.getDouble("solde"));
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Impossible de récupérer les données");
		} finally {

			if (result != null)
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (stm != null)
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return user;
	}
	
	public void startTransaction() {
		PreparedStatement stm = null;
		try {
			stm = this.connect.prepareStatement("START TRANSACTION");
			stm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (stm != null)
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void commit() {
		PreparedStatement stm = null;
		try {
			stm = this.connect.prepareStatement("COMMIT");
			stm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (stm != null)
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void rollback() {
		PreparedStatement stm = null;
		try {
			stm = this.connect.prepareStatement("ROLLBACK");
			stm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (stm != null)
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
