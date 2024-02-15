package persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import cliente.Cliente;
import utils.Utilitarios;

public class Tb_Clientes extends ArrayList<Cliente> {
	private static final long serialVersionUID = 1L;
	
	public void readFile() {
		try {
			FileInputStream fis = new FileInputStream("Tb_Clientes.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				try {
					Cliente c = (Cliente)ois.readObject();
					this.add(c);
				} catch (EOFException e) {
					break;
				}
			}
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			Utilitarios.Cx_Msg("Erro ao abrir o arquivo de clientes: " + e.getMessage());
		}
	}
	
	public void saveFile() {
		try {
			FileOutputStream fos = new FileOutputStream("Tb_Clientes.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Cliente cliente : this) {
				oos.writeObject(cliente);
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			Utilitarios.Cx_Msg("Erro ao salvar no arquivo de clientes: " + e.getMessage());
		}
	}
	
	public void insert(Cliente cliente) throws Exception {
		if (cliente == null) throw new Exception("Um cliente nulo foi passado");
		if (this.contains(cliente)) throw new Exception("O cliente já está cadastrado na lista");
		this.add(cliente);
	}
	
	public void delete(Cliente cliente) throws Exception {
        if (cliente == null) throw new Exception("Um cliente nulo foi passado");
        if (!this.contains(cliente)) throw new Exception("O cliente não está cadastrado na lista");
        this.remove(cliente);
    }
	
	public Cliente findByCPF(String CPF) {
		for (Cliente c : this) 
			if (c.getCPF().equals(CPF))	return c;
		return null;
    }
	
	public void createCliente() throws Exception {
		Utilitarios.limpaTela();
		Cliente cliente = new Cliente();
		String cpf = Utilitarios.lerString("Digite o nome do CPF do cliente: ");
		if(findByCPF(cpf) != null) throw new Exception("Já existe um cliente cadastrado com o cpf informado!");
		cliente.setCPF(cpf);
		String nome = Utilitarios.lerString("Digite o nome do cliente: ");
		cliente.setNome(nome);
		this.insert(cliente);
		this.saveFile();
		Utilitarios.Cx_Msg("Cliente cadastrado com sucesso!");
	}
	
	public void listarClientes() {
		Utilitarios.limpaTela();
		System.out.println("Lista de clientes cadastrados:");
        for (Cliente c : this) 
            System.out.println(c.toString());
        Utilitarios.pausaTela();;
	}
	
	public void update() throws Exception {
		Utilitarios.limpaTela();
        String cpf = Utilitarios.lerString("Digite o cpf do cliente que deseja atualizar: ");
        Cliente cliente = findByCPF(cpf);
        if (cliente == null) throw new Exception("O cliente não foi encontrado!");
        Utilitarios.limpaTela();
        System.out.println("Digite o nome do cliente: ");
        String nome = Utilitarios.lerString("Digite o nome do cliente: ");
        cliente.setNome(nome);
        this.saveFile();
        Utilitarios.Cx_Msg("Nome do cliente alterado com sucesso!");
	}
	
	public void deleteCliente() throws Exception {
		Utilitarios.limpaTela();
		String cpf = Utilitarios.lerString("Digite o cpf do cliente que deseja remover:");
		Cliente cliente = findByCPF(cpf);
		if (cliente == null) throw new Exception("O cliente não foi encontrado!");
		String op = Utilitarios.lerString("Remover o cliente: " + cliente.getNome() + ". Tem certeza? ([S]im / [N]ão)");
		while(!op.equalsIgnoreCase("s") && !op.equalsIgnoreCase("n")) {
			System.out.println("Opção inválida!");
			op = Utilitarios.lerString("Remover o cliente: " + cliente.getNome() + ". Tem certeza? ([S]im / [N]ão)");
		}
		if (op.equalsIgnoreCase("s")) {
            this.delete(cliente);
            this.saveFile();
            Utilitarios.Cx_Msg("Cliente removido com sucesso!");
        }
	}
}
