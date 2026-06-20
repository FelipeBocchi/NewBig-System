package com.newBig.system.model.service.usuario;

import com.newBig.system.model.entity.Cliente;
import com.newBig.system.model.entity.Funcionario;

import java.util.List;

public interface DadosUsuarioServiceItf {

    List<Funcionario> dadosFuncionario();

    List<Funcionario> dadosFuncionarioNome(String nome);

    Funcionario dadosCompletosFuncionario(Long id);

    List<Cliente> dadosCliente();

    List<Cliente> dadosClienteNome(String nome);

    List<Cliente> dadosClienteCpf(String cpf);

}
