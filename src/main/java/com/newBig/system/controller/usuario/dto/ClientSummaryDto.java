package com.newBig.system.controller.usuario.dto;

public record ClientSummaryDto(
        Long id,
        String name,
        String cpf,
        String cep,
        String rua,
        int numero,
        String bairro,
        String telefone
) {
}
