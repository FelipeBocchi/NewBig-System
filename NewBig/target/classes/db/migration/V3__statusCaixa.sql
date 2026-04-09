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

ALTER TABLE dados_caixa
    ADD COLUMN status int not null;
