package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cliente.Cliente;
import imovel.Imovel;

public class ImovelDAO {
	public static void add(Imovel imovel) throws Exception {
		Connection con = DAO.conectar();  
		try {
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO IMOVEL (MATRICULA, ENDERECO, LEITURA_ANT, LEITURA_ATUAL, ID_CLIENTE) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, imovel.getMatricula());
			preparedStatement.setString(2, imovel.getEndereco());
			preparedStatement.setInt(3, imovel.getLeituraAterior());
			preparedStatement.setInt(4, imovel.getLeituraAtual());
			preparedStatement.setInt(5, imovel.getProprietario().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static Imovel findByID(int id) throws Exception {
		Connection con = DAO.conectar();
		try {
			PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM IMOVEL WHERE ID = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				throw new Exception("Não foi encontrado imóvel com o ID informado!");
			}
			return newImovel(resultSet);
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);			
		}
    }
	
	public static ArrayList<Imovel> findAll() throws Exception {
    	Connection con = DAO.conectar();
    	ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
    	String query = "SELECT * FROM IMOVEL";

    	try {
    		PreparedStatement preparedStatement = con.prepareStatement(query);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			Imovel imovel = new Imovel();
    			imovel = newImovel(resultSet);
    			imoveis.add(imovel);
    		}
    		if(imoveis.size() == 0) {
    			throw new SQLException("Não foi encontrado nenhum imóvel!");
    		}
    		return imoveis;
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
    }
	
	public static ArrayList<Imovel> findAllByCliente(Cliente cliente) throws Exception {
		Connection con = DAO.conectar();
        ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
        String query = "SELECT * FROM IMOVEL WHERE ID_CLIENTE = ?";
        
        try {
        	PreparedStatement preparedStatement = con.prepareStatement(query);
        	preparedStatement.setInt(1, cliente.getId());
    		ResultSet resultSet = preparedStatement.executeQuery();
    		while (resultSet.next()) {
    			Imovel imovel = new Imovel();
    			imovel = newImovel(resultSet);
    			imoveis.add(imovel);
    		}
    		if(imoveis.size() == 0) {
    			throw new SQLException("Não foi encontrado nenhum imóvel relacionado ao cliente!");
    		}
    		return imoveis;
        } catch (SQLException e) {
        	throw new Exception(e.getMessage());
		} finally {
			DAO.close(con);
		}
	}
	
	public static void update(Imovel imovel) throws Exception {
    	Connection con = DAO.conectar();
        String query = "UPDATE IMOVEL SET matricula = ?, endereco = ?, leitura_ant = ?, leitura_atual = ?, id_cliente = ? WHERE id = ?";
        try {
        	PreparedStatement preparedStatement = con.prepareStatement(query);
        	preparedStatement.setString(1, imovel.getMatricula());
        	preparedStatement.setString(2, imovel.getEndereco());
        	preparedStatement.setInt(3, imovel.getLeituraAterior());
        	preparedStatement.setInt(4, imovel.getLeituraAtual());
        	preparedStatement.setInt(5, imovel.getProprietario().getId());
        	preparedStatement.setInt(6, imovel.getId());
        	preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        } finally {
        	DAO.close(con);
        }
    }
	
    public static void delete(int id) throws Exception {
    	Connection con = DAO.conectar();
        String query = "DELETE FROM IMOVEL WHERE id = ?";

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
	
	private static Imovel newImovel(ResultSet resultSet) throws Exception {
		Imovel imovel = new Imovel();
        imovel.setId(resultSet.getInt("ID"));
        imovel.setMatricula(resultSet.getString("MATRICULA"));
        imovel.setEndereco(resultSet.getString("ENDERECO"));
        imovel.setLeituraAterior(resultSet.getInt("LEITURA_ANT"));
        imovel.setLeituraAtual(resultSet.getInt("LEITURA_ATUAL"));
        imovel.setProprietario(ClienteDAO.findByID(resultSet.getInt("ID_CLIENTE")));
        return imovel;
	}
}
