package com.newBig.system.model.service.usuario;

public interface CadastroUsuarioServiceItf {

    void novoCliente(String nome, String cpf, String cep, String rua, int numero, String bairro, String telefone);

    void novoFuncionario(String nome, String cpf, int acesso, String login, int senha);

    Long ultimoId();

    Long ultimoIdFun();

    void limparBuffer();

}
