package com.carcara.oracle.kitchencloud.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record CadastroEstoqueDTO(
        @Schema(defaultValue = "8")
        Long codEstoque,
        Integer pesoProduto,
        Integer quantidadeProduto,
        LocalDate dataEntrada,
        LocalDate dataValidade,
        Integer capacidade,
        Integer estoqueMinimo,
        Long codItemCompra
) {
}
