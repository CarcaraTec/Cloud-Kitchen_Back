package com.carcara.oracle.kitchencloud.model.DTO;

import com.carcara.oracle.kitchencloud.model.Estoque;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public record DadosListagemEstoque(

        Long codItemEstoque,
        String descProduto,
        Integer pesoProduto,
        Integer quantidadeProduto,
        LocalDate dataEntrada,
        LocalDate dataValidade

) {

    public DadosListagemEstoque(Estoque estoque){
        this(estoque.getCodItemEstoque(),
                estoque.getDescProduto(),
                estoque.getPesoProduto(),
                estoque.getQuantidadeProduto(),
                estoque.getDataEntrada(),
                estoque.getDataValidade());
    }
}
