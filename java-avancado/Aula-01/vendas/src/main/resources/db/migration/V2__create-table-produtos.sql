create table Tb_Produtos(
	
	id bigint not null auto_increment,
	nome varchar(100) not null,
	preco double precision not null default '0.00',
	
	primary key(id)

);