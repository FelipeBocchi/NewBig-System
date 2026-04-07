CREATE TABLE funcionario(
    id serial primary key,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    acesso int not null,
    login varchar(100) not null,
    senha int not null
)

CREATE TABLE cliente(
    id serial primary key,
    nome varchar(100) not null,
    cpf varchar(11) not null unique,
    cep varchar(8) not null,
    rua varchar(100) not null,
    numero int,
    bairro varchar(100) not null,
    telefone varchar(11) not null
)