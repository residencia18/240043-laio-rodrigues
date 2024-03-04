package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cliente.Cliente;

public class ClienteDAO {
	
	public static void add(Cliente cliente) throws Exception {
		Connection con = DAO.conectar();  
		try {
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO CLIENTE (NOME, CPF) VALUES (?, ?)");
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCPF());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static Cliente findByID(int id) throws Exception {
		Connection con = DAO.conectar();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM CLIENTE WHERE ID = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new Exception("Não foi encontrado cliente com o ID informado!");
			}
			return newCliente(resultSet);
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);			
		}
    }
	
	public static ArrayList<Cliente> findAll() throws Exception {
    	Connection con = DAO.conectar();
    	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    	String query = "SELECT * FROM CLIENTE";

    	try {
    		PreparedStatement preparedStatement = con.prepareStatement(query);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			Cliente cliente = new Cliente();
    			cliente = newCliente(resultSet);
    			clientes.add(cliente);
    		}
    		if(clientes.size() == 0) {
    			throw new SQLException("Não foi encontrado nenhum cliente!");
    		}
    		return clientes;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static void update(Cliente cliente) throws Exception {
    	Connection con = DAO.conectar();
        String query = "UPDATE CLIENTE SET nome = ?, cpf = ? WHERE id = ?";
        try {
        	PreparedStatement preparedStatement = con.prepareStatement(query);
        	preparedStatement.setString(1, cliente.getNome());
        	preparedStatement.setString(2, cliente.getCPF());
        	preparedStatement.setInt(3, cliente.getId());
        	preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
        	DAO.close(con);
        }
    }
	
    public static void delete(int id) throws Exception {
    	Connection con = DAO.conectar();
        String query = "DELETE FROM CLIENTE WHERE id = ?";

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
	
	private static Cliente newCliente(ResultSet resultSet) throws Exception {
		Cliente cliente = new Cliente();
        cliente.setId(resultSet.getInt("ID"));
        cliente.setNome(resultSet.getString("NOME"));
        cliente.setCPF(resultSet.getString("CPF"));
        return cliente;
	}
}
