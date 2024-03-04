package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

	private static final String URL = "jdbc:mysql://uqxvntda9vwgjy7u:GCQKKJoBmPh8xVjeKLJy@bnl2bhfuorbsfrrjv0n5-mysql.services.clever-cloud.com:3306/bnl2bhfuorbsfrrjv0n5";
	private static final String USER = "uqxvntda9vwgjy7u";
	private static final String SENHA = "GCQKKJoBmPh8xVjeKLJy";

	public static Connection conectar() throws Exception {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, SENHA);
		} catch (SQLException e) {
			throw new Exception("Erro na conexão com o Banco de dados: " + e.getMessage());
		}
		return con;
	}
	
	public static void teste() {
		try {
			Connection con = conectar();
			System.out.println(con);
			close(con);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
	
	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
