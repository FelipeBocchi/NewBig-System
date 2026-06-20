package com.newBig.system.controller.usuario.impl;

import com.newBig.system.controller.usuario.UsuarioControllerInterface;
import com.newBig.system.controller.usuario.dto.ClientDateDto;
import com.newBig.system.controller.usuario.dto.ClientSummaryDto;
import com.newBig.system.model.entity.Cliente;
import com.newBig.system.model.service.usuario.AtualizarUsuarioServiceItf;
import com.newBig.system.model.service.usuario.CadastroUsuarioServiceItf;
import com.newBig.system.model.service.usuario.DadosUsuarioServiceItf;
import com.newBig.system.model.service.usuario.DeletarUsuarioServiceItf;

import java.util.ArrayList;
import java.util.List;

public class UsuarioControllerImpl implements UsuarioControllerInterface {

    private AtualizarUsuarioServiceItf atualizarUsario;
    private CadastroUsuarioServiceItf cadastroUsuario;
    private DadosUsuarioServiceItf dadosUsuario;
    private DeletarUsuarioServiceItf deletarUsuario;

    public UsuarioControllerImpl(AtualizarUsuarioServiceItf atualizarUsario, CadastroUsuarioServiceItf cadastroUsuario, DadosUsuarioServiceItf dadosUsuario, DeletarUsuarioServiceItf deletarUsuario) {
        this.atualizarUsario = atualizarUsario;
        this.cadastroUsuario = cadastroUsuario;
        this.dadosUsuario = dadosUsuario;
        this.deletarUsuario = deletarUsuario;
    }


    @Override
    public void deleteUser(Long id) {
        deletarUsuario.deleteCliente(id);
    }

    @Override
    public List<ClientDateDto> clientDateAll() {
        List<Cliente> list = dadosUsuario.dadosCliente();
        List<ClientDateDto> listDto = new ArrayList<>();

        for (Cliente cliente : list) {
            listDto.add(new ClientDateDto(cliente.getId(), cliente.getNome(), cliente.getCpf()));
        }

        return listDto;
    }

    @Override
    public ClientSummaryDto clientDateId(Long id) {
        Cliente cliente = atualizarUsario.dadosCliente(id);

        return new ClientSummaryDto(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getCep(), cliente.getRua(), cliente.getNumero(), cliente.getBairro(), cliente.getTelefone());
    }

    @Override
    public List<ClientDateDto> clientDateName(String name) {
        List<Cliente> list = dadosUsuario.dadosClienteNome(name);
        List<ClientDateDto> listDto = new ArrayList<>();

        for (Cliente cliente : list) {
            listDto.add(new ClientDateDto(cliente.getId(), cliente.getNome(), cliente.getCpf()));
        }

        return listDto;
    }

    @Override
    public List<ClientDateDto> clientDateCpf(String cpf) {
        List<Cliente> list = dadosUsuario.dadosClienteNome(cpf);
        List<ClientDateDto> listDto = new ArrayList<>();

        for (Cliente cliente : list) {
            listDto.add(new ClientDateDto(cliente.getId(), cliente.getNome(), cliente.getCpf()));
        }

        return listDto;
    }

    @Override
    public void updateUser(Long id, String name, String cpf, String cep, String rua, int numero, String bairro, String telefone) {
        atualizarUsario.cliente(id, name, cpf, cep, rua, numero, bairro, telefone);
    }
}
