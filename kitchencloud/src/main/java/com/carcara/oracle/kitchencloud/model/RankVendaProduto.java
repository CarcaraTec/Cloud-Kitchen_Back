package com.carcara.oracle.kitchencloud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Subselect;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Subselect("")
public class RankVendaProduto {

    @Id
    private Long codPrato;

    private String nomePrato;

    private String diaDaSemana;

    private Integer quantidadeTotal;

    private BigDecimal valorTotalProduto;

    private BigDecimal impactoPorcentagem;

    public String getDiaDaSemana() {
        return diaDaSemana.replaceAll(" ","");
    }
}
