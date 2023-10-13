package com.carcara.oracle.kitchencloud.model.dto;

import com.carcara.oracle.kitchencloud.model.Estoque;

import java.time.LocalDate;

public record ExibicaoEstoqueDTO(
        Long codEstoque,
        Integer pesoProduto,
        Integer quantidadeProduto,
        LocalDate dataEntrada,
        LocalDate dataValidade,
        Integer capacidade,
        Integer estoqueMinimo,
        Long codItemCompra
) {
    public ExibicaoEstoqueDTO(Estoque estoque) {
        this(estoque.getCodEstoque(),
                estoque.getPesoProduto(),
                estoque.getQuantidadeProduto(),
                estoque.getDataEntrada(),
                estoque.getDataValidade(),
                estoque.getCapacidade(),
                estoque.getEstoqueMinimo(),
                estoque.getItemCompra().getCodItemCompra()
        );
    }
}
