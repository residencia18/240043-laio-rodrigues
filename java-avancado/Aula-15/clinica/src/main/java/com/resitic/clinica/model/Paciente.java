package com.resitic.clinica.model;

import com.resitic.clinica.controller.forms.PacienteFORM;
import com.resitic.clinica.controller.forms.UpdatePacienteFORM;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private boolean ativo;
	
	@Embedded
	private Endereco endereco;
	
	public Paciente(PacienteFORM pacienteFORM) {
		this.nome = pacienteFORM.nome();
        this.email = pacienteFORM.email();
        this.cpf = pacienteFORM.cpf();
        this.telefone = pacienteFORM.telefone();
        this.endereco = new Endereco(pacienteFORM.endereco());
        this.ativo = true;
	}

	public void update(UpdatePacienteFORM pacienteFORM) {
		if (pacienteFORM.nome() != null)
			this.nome = pacienteFORM.nome();
        if (pacienteFORM.telefone() != null)
        	this.telefone = pacienteFORM.telefone();
        if (pacienteFORM.endereco()!= null)
        	this.endereco.update(pacienteFORM.endereco());
	}

	public void delete() {
		this.ativo = false;
	}
}
