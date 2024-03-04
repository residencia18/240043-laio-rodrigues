package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import fatura.Reembolso;


public class ReembolsoDAO {
	public static void add(Reembolso reembolso) throws Exception {
		Connection con = DAO.conectar();  
		try {
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO REEMBOLSO (DATA, VALOR, ID_PAGAMENTO) VALUES (?, ?, ?)");
			preparedStatement.setDate(1, new java.sql.Date(reembolso.getData().getTimeInMillis()));
			preparedStatement.setDouble(2, reembolso.getValor());
			preparedStatement.setInt(3, reembolso.getPagamento().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static Reembolso findByID(int id) throws Exception {
		Connection con = DAO.conectar();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM REEMBOLSO WHERE ID = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new Exception("Não foi encontrado reembolso com o ID informado!");
			}
			return newReembolso(resultSet);
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);			
		}
    }
	
	public static ArrayList<Reembolso> findAll() throws Exception {
    	Connection con = DAO.conectar();
    	ArrayList<Reembolso> reembolsos = new ArrayList<Reembolso>();
    	String query = "SELECT * FROM REEMBOLSO";

    	try {
    		PreparedStatement preparedStatement = con.prepareStatement(query);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			Reembolso reembolso = new Reembolso();
    			reembolso = newReembolso(resultSet);
    			reembolsos.add(reembolso);
    		}
    		if(reembolsos.size() == 0) {
    			throw new SQLException("Não foi encontrado nenhum reembolso!");
    		}
    		return reembolsos;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static void update(Reembolso reembolso) throws Exception {
    	Connection con = DAO.conectar();
        String query = "UPDATE REEMBOLSO SET data = ?, valor = ?, id_pagamento = ? WHERE id = ?";
        try {
        	PreparedStatement preparedStatement = con.prepareStatement(query);
        	preparedStatement.setDate(1, new java.sql.Date(reembolso.getData().getTimeInMillis()));
        	preparedStatement.setDouble(4, reembolso.getValor());
        	preparedStatement.setInt(6, reembolso.getPagamento().getId());
        	preparedStatement.setInt(7, reembolso.getId());
        	preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
        	DAO.close(con);
        }
    }
	
    public static void delete(int id) throws Exception {
    	Connection con = DAO.conectar();
        String query = "DELETE FROM REEMBOLSO WHERE id = ?";

        try {
        	PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
        	DAO.close(con);
        }
    }
	
	private static Reembolso newReembolso(ResultSet resultSet) throws Exception {
		Reembolso reembolso = new Reembolso();
		reembolso.setId(resultSet.getInt("ID"));
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(resultSet.getDate("DATA").getTime());
		reembolso.setData(cal);
		reembolso.setValor(resultSet.getDouble("VALOR"));
		reembolso.setPagamento(PagamentoDAO.findByID(resultSet.getInt("ID_PAGAMENTO")));
        return reembolso;
	}

}
