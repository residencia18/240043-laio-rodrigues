create table Tb_Pagamentos(
	
	id bigint not null auto_increment,
	valor_pago double precision not null default '0.00',
	id_venda bigint not null,
	
	primary key(id),
	foreign key (id_venda) references Tb_Vendas(id)

);