package com.newBig.system.model.service.usuario;

import com.newBig.system.model.entity.Cliente;
import com.newBig.system.model.entity.Funcionario;

public interface AtualizarUsuarioServiceItf {

    void funcionario(Long id, String nome, String cpf, String login, int senha, int acesso);

    void cliente(Long id, String nome, String cpf, String cep, String rua, int numero, String bairro, String telefone);

    Cliente dadosCliente(Long id);

    Funcionario dadosFuncionario(Long id);

}
