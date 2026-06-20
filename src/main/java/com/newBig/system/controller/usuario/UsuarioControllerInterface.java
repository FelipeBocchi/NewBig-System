package com.newBig.system.controller.usuario;

import com.newBig.system.controller.usuario.dto.ClientDateDto;
import com.newBig.system.controller.usuario.dto.ClientSummaryDto;

import java.util.List;

public interface UsuarioControllerInterface {

    void deleteUser(Long id);

    List<ClientDateDto> clientDateAll();

    ClientSummaryDto clientDateId(Long id);

    List<ClientDateDto> clientDateName(String name);

    List<ClientDateDto> clientDateCpf(String cpf);

    void updateUser(Long id, String name, String cpf, String cep, String rua, int numero, String bairro, String telefone);

}
