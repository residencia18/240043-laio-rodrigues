package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cliente.Cliente;

public class ClienteDAO {
	
	public static boolean adicionarCliente(Cliente cliente) {
    	try (Connection con = DAO.conectar();
    		 PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO CLIENTE (NOME, CPF) VALUES (?, ?)")) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCPF());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
        	System.err.println("Erro ao adicionar o cliente: " + e);
            return false;
        }
    }
	
	public static Cliente buscarCliente(int id) throws Exception {
		try (Connection con = DAO.conectar();
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM CLIENTE WHERE ID = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return criarCliente(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		throw new Exception();
    }
	
	public static ArrayList<Cliente> obterTodosClientes() {
    	Connection con = DAO.conectar();
    	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    	String query = "SELECT * FROM CLIENTE";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente = criarCliente(resultSet);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DAO.closeConnection(con);
        }

        return clientes;
    }
	
	public static void atualizarCliente(Cliente cliente) {
    	Connection con = DAO.conectar();
        String query = "UPDATE CLIENTE SET nome = ?, cpf = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getCPF());
            preparedStatement.setInt(3, cliente.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DAO.closeConnection(con);
        }
    }
	
    public static void excluirCliente(int id) {
    	Connection con = DAO.conectar();
        String query = "DELETE FROM CLIENTE WHERE id = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	DAO.closeConnection(con);
        }
    }
	
	private static Cliente criarCliente(ResultSet resultSet) throws SQLException {
		Cliente cliente = new Cliente();
        cliente.setId(resultSet.getInt("ID"));
        try {
			cliente.setNome(resultSet.getString("NOME"));
		} catch (Exception e) {
			System.err.println("Erro ao definir o nome do cliente: " + e);
		}
        try {
			cliente.setCPF(resultSet.getString("CPF"));
		} catch (Exception e) {
			System.err.println("Erro ao definir o CPF do cliente: " + e);
		}
        return cliente;
	}
}
