create table Tb_Clientes(
	
	id bigint not null auto_increment,
	nome varchar(100) not null,
	cpf varchar(11) not null unique,
	
	primary key(id)

);

create table Tb_Vendas(
	
	id bigint not null auto_increment,
	valor_total double precision not null default '0.00',
	quitado boolean not null default false,
	id_cliente bigint not null,
	
	primary key(id),
	foreign key (id_cliente) references Tb_Clientes(id)

);