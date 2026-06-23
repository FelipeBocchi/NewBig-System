package com.newBig.system.controller.usuario;

import com.newBig.system.controller.usuario.dto.ClientDateDto;
import com.newBig.system.controller.usuario.dto.ClientSummaryDto;
import com.newBig.system.controller.usuario.dto.FuncionarioDateDto;

import java.util.List;

public interface UsuarioControllerInterface {

    void registerNewUser(String name, String cpf, String cep, String rua, int numero, String bairro, String telefone);

    void deleteUser(Long id);

    List<ClientDateDto> clientDateAll();

    ClientSummaryDto clientDateId(Long id);

    List<ClientDateDto> clientDateName(String name);

    List<ClientDateDto> clientDateCpf(String cpf);

    Long lastId();

    void updateUser(Long id, String name, String cpf, String cep, String rua, int numero, String bairro, String telefone);

    //  = Funcionario

    void registerNewFuncionario(String name, String cpf, int acesso, String login, int senha);

    void deleteFuncionario(Long id);

    void updateFuncionario(Long id, String nome, String cpf, String login, int senha, int acesso);

    FuncionarioDateDto funcionarioDateId(Long id);

    Long lastIdFun();

}
