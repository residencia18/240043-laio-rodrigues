package com.resitic.clinica.model;

import java.time.LocalDateTime;

import com.resitic.clinica.controller.enums.MotivoENUM;
import com.resitic.clinica.controller.enums.StatusConsultaENUM;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_medico")
	private Medico medico;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
	
	private LocalDateTime data;
	
	@Enumerated(EnumType.STRING)
	private StatusConsultaENUM status;
	
	@Column(name = "motivo_cancelamento")
	@Enumerated(EnumType.STRING)
	private MotivoENUM motivoCancelamento;
	
	public void realizar() {
        this.status = StatusConsultaENUM.REALIZADA;
    }
	
	public void cancelar(MotivoENUM motivo) {
		this.status = StatusConsultaENUM.CANCELADA;
		this.motivoCancelamento = motivo;
	}
	
}