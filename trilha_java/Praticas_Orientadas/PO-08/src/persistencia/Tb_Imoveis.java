package persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import cliente.Cliente;
import imovel.Imovel;
import utils.Utilitarios;

public class Tb_Imoveis extends ArrayList<Imovel> {
	private static final long serialVersionUID = 1L;
	
	public void readFile() {
		try {
			FileInputStream fis = new FileInputStream("Tb_Imoveis.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				try {
					Imovel c = (Imovel)ois.readObject();
					this.add(c);
				} catch (EOFException e) {
					break;
				}
			}
			ois.close();
			fis.close();
		} catch (IOException | ClassNotFoundException e) {
			Utilitarios.Cx_Msg("Erro ao abrir o arquivo de imóveis: " + e.getMessage());
		}
	}
	
	public void saveFile() {
		try {
			FileOutputStream fos = new FileOutputStream("Tb_Imoveis.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Imovel imovel : this) {
				oos.writeObject(imovel);
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			Utilitarios.Cx_Msg("Erro ao salvar no arquivo de imóveis: " + e.getMessage());
		}
	}
	
	private void insert(Imovel imovel) throws Exception {
		if (imovel == null) throw new Exception("Um imovel nulo foi passado");
		if (this.contains(imovel)) throw new Exception("O imóvel já está cadastrado na lista");
		this.add(imovel);
	}
	
	private void delete(Imovel imovel) throws Exception {
        if (imovel == null) throw new Exception("Um imovel nulo foi passado");
        if (!this.contains(imovel)) throw new Exception("O imóvel não está cadastrado na lista");
        this.remove(imovel);
    }
	
	public Imovel findByMatricula(String matricula) throws Exception {
		if (matricula == null) throw new Exception("Um matricula nula foi passado");
		for (Imovel imovel : this)
            if (imovel.getMatricula().equals(matricula)) return imovel;
        return null;
	}
	
	public ArrayList<Imovel> findAllByProprietario(Cliente proprietario) throws Exception {
		if (proprietario == null) throw new Exception("Um proprietário nulo foi passado");
		ArrayList<Imovel> lista = new ArrayList<Imovel>();
        for (Imovel imovel : this) {        	
            if (imovel.getProprietario().equals(proprietario)) 
            	lista.add(imovel);
        }
        return lista;
	}
	
	public void createImovel(Cliente proprietario) throws Exception {
		Imovel imovel = new Imovel();
		String matricula = Utilitarios.lerString("Digite o número da matrícula: ");
		if(findByMatricula(matricula) != null) throw new Exception("Já existe um imóvel cadastrado com a matrícula informada!");
		imovel.setMatricula(matricula);
		String endereco = Utilitarios.lerString("Digite o endereço: ");
		imovel.setEndereco(endereco);
		imovel.setProprietario(proprietario);
		this.insert(imovel);
		this.saveFile();
		Utilitarios.Cx_Msg("Imovel cadastrado com sucesso!");
	}
	
	public void listarImoveis() {
		Utilitarios.limpaTela();
		System.out.println("Lista de Imóveis: ");
		for (Imovel imovel : this) {
            System.out.println(imovel.toString());
        }
		Utilitarios.pausaTela();
	}
	
	public void editarImovel(Tb_Clientes clientes) throws Exception {
		Utilitarios.limpaTela();
		Imovel imovel = findByMatricula(Utilitarios.lerString("Informe a matricula do Imovel: "));
		if (imovel == null) throw new Exception("O imóvel não foi encontrado");
		Cliente proprietario = clientes.findByCPF(Utilitarios.lerString("Informe o CPF do novo proprietário"));
		if(proprietario == null) throw new Exception("O CPF não corresponde a um cliente cadastrado!");
		imovel.setProprietario(proprietario);
		this.saveFile();
		Utilitarios.Cx_Msg("Novo proprietário adicionado com sucesso!");
	}
	
	public void removerImovel() throws Exception {
		Utilitarios.limpaTela();
        Imovel imovel = findByMatricula(Utilitarios.lerString("Informe a matricula do Imovel: "));
        if (imovel == null) throw new Exception("O imóvel não foi encontrado");
        String op = Utilitarios.lerString("Remover o imóvel: " + imovel.toString() + "\n Tem certeza? ([S]im / [N]ão): ");
        while(!op.equalsIgnoreCase("s") && !op.equalsIgnoreCase("n")) {
        	System.out.println("Opção inválida!");
        	op = Utilitarios.lerString("Remover o imóvel: " + imovel.toString() + "\n Tem certeza? ([S]im / [N]ão): ");
        }
        if(op.equalsIgnoreCase("n")) return;
        this.delete(imovel);
        this.saveFile();
        Utilitarios.Cx_Msg("Imovel removido com sucesso!");
	}
	
	public void novaLeitura() throws Exception {
		Utilitarios.limpaTela();
        Imovel imovel = findByMatricula(Utilitarios.lerString("Informe a matricula do Imovel: "));
        if (imovel == null) throw new Exception("O imóvel não foi encontrado");
        imovel.novaLeitura(Utilitarios.lerInteiro("Informe a nova leitura: "));
        this.saveFile();
        Utilitarios.Cx_Msg("Nova leitura adicionada com sucesso!");
	}
}
