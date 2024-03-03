package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

	private static final String URL = "jdbc:";
	private static final String USER = "";
	private static final String SENHA = "";

	public static Connection conectar() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, SENHA);
		} catch (SQLException e) {
			e.getStackTrace();
			throw new RuntimeException("Erro na conexão com o Banco de dados: ", e);
		}
		return con;
	}
	
	public static void testeConnexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			closeConnection(con);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}

	}
	
	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
