package com.resitic.clinica.model;

import com.resitic.clinica.controller.enums.EspecialidadeENUM;
import com.resitic.clinica.controller.forms.MedicoFORM;
import com.resitic.clinica.controller.forms.UpdateMedicoFORM;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String crm;
	private String telefone;
	private boolean ativo;
	
	@Enumerated(EnumType.STRING)
	private EspecialidadeENUM especialidade;
	
	@Embedded
	private Endereco endereco;
	
	public Medico(MedicoFORM medicoFORM) {
		this.nome = medicoFORM.nome();
        this.email = medicoFORM.email();
        this.crm = medicoFORM.crm();
        this.especialidade = medicoFORM.especialidade();
        this.endereco = new Endereco(medicoFORM.endereco());
        this.telefone = medicoFORM.telefone();
        this.ativo = true;
	}

	public void update(UpdateMedicoFORM medicoFORM) {
		if (medicoFORM.nome() != null)
			this.nome = medicoFORM.nome();
        if (medicoFORM.telefone() != null)
        	this.telefone = medicoFORM.telefone();
        if (medicoFORM.endereco()!= null)
        	this.endereco.update(medicoFORM.endereco());
	}

	public void delete() {
		this.ativo = false;
	}
}
