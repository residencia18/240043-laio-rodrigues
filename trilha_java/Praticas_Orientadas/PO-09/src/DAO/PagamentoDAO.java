package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import fatura.Pagamento;


public class PagamentoDAO {
	public static void add(Pagamento pagamento) throws Exception {
		Connection con = DAO.conectar();  
		try {
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO PAGAMENTO (DATA, VALOR, ID_FATURA) VALUES (?, ?, ?)");
			preparedStatement.setDate(1, new java.sql.Date(pagamento.getData().getTimeInMillis()));
			preparedStatement.setDouble(2, pagamento.getValor());
			preparedStatement.setInt(3, pagamento.getFatura().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static Pagamento findByID(int id) throws Exception {
		Connection con = DAO.conectar();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM PAGAMENTO WHERE ID = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new Exception("Não foi encontrado pagamento com o ID informado!");
			}
			return newPagamento(resultSet);
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);			
		}
    }
	
	public static ArrayList<Pagamento> findAll() throws Exception {
    	Connection con = DAO.conectar();
    	ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();
    	String query = "SELECT * FROM PAGAMENTO";

    	try {
    		PreparedStatement preparedStatement = con.prepareStatement(query);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			Pagamento pagamento = new Pagamento();
    			pagamento = newPagamento(resultSet);
    			pagamentos.add(pagamento);
    		}
    		if(pagamentos.size() == 0) {
    			throw new SQLException("Não foi encontrado nenhum pagamento!");
    		}
    		return pagamentos;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static void update(Pagamento pagamento) throws Exception {
    	Connection con = DAO.conectar();
        String query = "UPDATE PAGAMENTO SET data = ?, valor = ?, id_imovel = ? WHERE id = ?";
        try {
        	PreparedStatement preparedStatement = con.prepareStatement(query);
        	preparedStatement.setDate(1, new java.sql.Date(pagamento.getData().getTimeInMillis()));
        	preparedStatement.setDouble(4, pagamento.getValor());
        	preparedStatement.setInt(6, pagamento.getFatura().getId());
        	preparedStatement.setInt(7, pagamento.getId());
        	preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
        	DAO.close(con);
        }
    }
	
    public static void delete(int id) throws Exception {
    	Connection con = DAO.conectar();
        String query = "DELETE FROM PAGAMENTO WHERE id = ?";

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
	
	private static Pagamento newPagamento(ResultSet resultSet) throws Exception {
		Pagamento pagamento = new Pagamento();
		pagamento.setId(resultSet.getInt("ID"));
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(resultSet.getDate("DATA").getTime());
		pagamento.setData(cal);
		pagamento.setValor(resultSet.getDouble("VALOR"));
		pagamento.setFatura(FaturaDAO.findByID(resultSet.getInt("ID_FATURA")));
        return pagamento;
	}
}
