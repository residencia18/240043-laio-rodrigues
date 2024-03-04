package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import fatura.Fatura;
import imovel.Imovel;


public class FaturaDAO {
	public static void add(Fatura fatura) throws Exception {
		Connection con = DAO.conectar();  
		try {
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO FATURA (DATA, LEITURA_ANT, LEITURA_ATUAL, VALOR, QUITADO, ID_IMOVEL) VALUES (?, ?, ?, ?, ?, ?)");
			preparedStatement.setDate(1, new java.sql.Date(fatura.getData().getTimeInMillis()));
			preparedStatement.setInt(2, fatura.getLeituraAnterior());
			preparedStatement.setInt(3, fatura.getLeituraAtual());
			preparedStatement.setDouble(4, fatura.getValor());
			preparedStatement.setBoolean(5, fatura.isQuitado());
			preparedStatement.setInt(6, fatura.getImovel().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static Fatura findByID(int id) throws Exception {
		Connection con = DAO.conectar();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM FATURA WHERE ID = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new Exception("Não foi encontrado fatura com o ID informado!");
			}
			return newFatura(resultSet);
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);			
		}
    }
	
	public static ArrayList<Fatura> findAll() throws Exception {
    	Connection con = DAO.conectar();
    	ArrayList<Fatura> faturas = new ArrayList<Fatura>();
    	String query = "SELECT * FROM FATURA";

    	try {
    		PreparedStatement preparedStatement = con.prepareStatement(query);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			Fatura fatura = new Fatura();
    			fatura = newFatura(resultSet);
    			faturas.add(fatura);
    		}
    		if(faturas.size() == 0) {
    			throw new SQLException("Não foi encontrado nenhuma fatura!");
    		}
    		return faturas;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static ArrayList<Fatura> findAllByImovel(Imovel imovel) throws Exception {
		Connection con = DAO.conectar();
        ArrayList<Fatura> faturas = new ArrayList<Fatura>();
        String query = "SELECT * FROM FATURA WHERE ID_IMOVEL =?";
        
        try {
        	PreparedStatement statement = con.prepareStatement(query);
        	statement.setInt(1, imovel.getId());
        	ResultSet resultSet = statement.executeQuery();
        	while (resultSet.next()) {
                Fatura fatura = new Fatura();
                fatura = newFatura(resultSet);
                faturas.add(fatura);
            }
        	if(faturas.size() == 0) {
                throw new SQLException("Não foi encontrado nenhuma fatura!");
            }
        	return faturas;
        } catch (SQLException e) {
        	throw new Exception(e.getMessage());
        } finally {
			DAO.close(con);
		}
	}
	
	public static ArrayList<Fatura> findAllOpen() throws Exception {
		Connection con = DAO.conectar();
        ArrayList<Fatura> faturas = new ArrayList<Fatura>();
        String query = "SELECT * FROM FATURA WHERE QUITADO = FALSE";
        
        try {
        	PreparedStatement statement = con.prepareStatement(query);
        	ResultSet resultSet = statement.executeQuery();
        	while (resultSet.next()) {
                Fatura fatura = new Fatura();
                fatura = newFatura(resultSet);
                faturas.add(fatura);
            }
        	if(faturas.size() == 0) {
                throw new Exception("Não foi encontrado nenhuma fatura em aberto!");
            }
        	return faturas;
        } catch (SQLException e) {
        	throw new Exception(e.getMessage());
        } finally {
        	DAO.close(con);
		}
	}
	
	public static void update(Fatura fatura) throws Exception {
    	Connection con = DAO.conectar();
        String query = "UPDATE FATURA SET data = ?, leitura_ant = ?, leitura_atual = ?, valor = ?, quitado = ?, id_imovel = ? WHERE id = ?";
        try {
        	PreparedStatement preparedStatement = con.prepareStatement(query);
        	preparedStatement.setDate(1, new java.sql.Date(fatura.getData().getTimeInMillis()));
        	preparedStatement.setInt(2, fatura.getLeituraAnterior());
        	preparedStatement.setInt(3, fatura.getLeituraAtual());
        	preparedStatement.setDouble(4, fatura.getValor());
        	preparedStatement.setBoolean(5, fatura.isQuitado());
        	preparedStatement.setInt(6, fatura.getImovel().getId());
        	preparedStatement.setInt(7, fatura.getId());
        	preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
        	DAO.close(con);
        }
    }
	
    public static void delete(int id) throws Exception {
    	Connection con = DAO.conectar();
        String query = "DELETE FROM FATURA WHERE id = ?";

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
	
	private static Fatura newFatura(ResultSet resultSet) throws Exception {
		Fatura fatura = new Fatura();
		fatura.setId(resultSet.getInt("ID"));
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(resultSet.getDate("DATA").getTime());
		fatura.setData(cal);
		fatura.setLeituras(resultSet.getInt("LEITURA_ANT"), resultSet.getInt("LEITURA_ATUAL"));
		fatura.setValor(resultSet.getDouble("VALOR"));
		fatura.setQuitado(resultSet.getBoolean("QUITADO"));
		fatura.setImovel(ImovelDAO.findByID(resultSet.getInt("ID_IMOVEL")));
        return fatura;
	}
}
