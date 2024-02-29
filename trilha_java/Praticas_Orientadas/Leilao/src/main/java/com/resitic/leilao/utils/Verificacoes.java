package com.resitic.leilao.utils;

public class Verificacoes {
	
	public static void isIdValido(int id) throws Exception {
		if(id <= 0) throw new Exception("O Id não pode ser zero ou negativo!");	
	}
	
	public static void isValorValido(double valor) throws Exception {
        if(valor <= 0) throw new Exception("O Valor não pode ser zero ou negativo!");    
    }
	
	public static void isCPFValido(String cpf) throws Exception {
		if(cpf == null) throw new Exception("O CPF não pode ser nulo!");
		if(cpf.length()!= 11) throw new Exception("O CPF deve conter 11 dígitos!");
		if(!cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}")) throw new Exception("O CPF deve conter apenas números!");
	}
	
	public static void isNomeValido(String nome) throws Exception {
		if(nome == null) throw new Exception("O Nome não pode ser nulo!");
        if(nome.length() < 3) throw new Exception("O Nome deve conter no mínimo 3 caracteres!");
        if(nome.length() > 50) throw new Exception("O Nome deve conter no máximo 50 caracteres!");;
	}
	
	public static void isDescricaoValida(String descricao) throws Exception {
		if(descricao == null) throw new Exception("A Descrição não pode ser nula!");
        if(descricao.length() < 3) throw new Exception("A Descrição deve conter no mínimo 3 caracteres!");
        if(descricao.length() > 100) throw new Exception("A Descrição deve conter no máximo 100 caracteres!");
	}
	
}
