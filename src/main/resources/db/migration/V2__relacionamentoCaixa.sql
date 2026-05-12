CREATE TABLE IF NOT EXISTS funcionario(
    id serial primary key,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    acesso int not null,
    login varchar(100) not null,
    senha int not null
    );

CREATE TABLE IF NOT EXISTS cliente(
    id serial primary key,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    cep varchar(8) not null,
    rua varchar(100) not null,
    numero int,
    bairro varchar(100) not null,
    telefone varchar(11) not null
    );

CREATE TABLE IF NOT EXISTS dados_caixa(
    id serial primary key,
    valorAbertura float not null,
    valorFechamento float,
    usuarioAbertura bigint not null,
    usuarioFechamento bigint,
    valorSangria float,
    dataAbertura date not null,
    dataFechamento date,
    horaAbertura time not null,
    horaFechamento time,
    foreign key(usuarioAbertura) references funcionario(id),
    foreign key(usuarioFechamento) references funcionario(id)
    );