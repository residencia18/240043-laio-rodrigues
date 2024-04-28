create table consultas(

	id bigint not null auto_increment,
	id_medico bigint not null,
	id_paciente bigint not null,
	data datetime not null,
	status varchar(100) not null,
	motivo_cancelamento varchar(100),
	
	primary key(id),
	constraint fk_consultas_id_medico foreign key(id_medico) references medicos(id),
	constraint fk_consultas_id_paciente foreign key(id_paciente) references pacientes(id)

);