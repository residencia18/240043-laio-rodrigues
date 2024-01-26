package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private static final String USER = "uqxvntda9vwgjy7u";
	private static final String PASSWD = "GCQKKJoBmPh8xVjeKLJy";
	private static final String DB = "bnl2bhfuorbsfrrjv0n5";
	private static final String PORT = "3306";
	private static final String URL = "jdbc:mysql://"+USER+":"+PASSWD+"@"+DB+"-mysql.services.clever-cloud.com:"+PORT+"/"+DB;
	
	public static void main(String[] args) {
		DAO.conectar();
	}

	public static Connection conectar() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("Conexão Feita com Sucesso!!!! ");
		} catch (SQLException e) {
			System.out.println("Erro de Conexão");
		}
		return con;
	}
	
}
