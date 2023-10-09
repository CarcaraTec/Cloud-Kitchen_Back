package com.carcara.oracle.kitchencloud.model.dto;

public record CadastroConfiguracaoAlertaDTO(
        String nomeAlerta,
        String descricao,
        String entidade,
        String condicaoDisparo,
        String valorParametro,
        String acao,
        String destinatarios
) {
}
