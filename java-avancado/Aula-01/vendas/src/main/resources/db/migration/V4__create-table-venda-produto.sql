create table Tb_Venda_Produto(
	
	id bigint not null auto_increment,
	quantidade integer not null,
	id_venda bigint not null,
	id_produto bigint not null,
	
	primary key(id),
	foreign key (id_venda) references Tb_Vendas(id),
	foreign key (id_produto) references Tb_Produtos(id)

);