package com.newBig.system.controller.usuario.dto;

public record FuncionarioDateDto(
        Long id,
        String name,
        String cpf,
        int acesso,
        String login,
        int senha
) {
}
