package com.carcara.oracle.kitchencloud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oracle.sql.CHAR;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cardapio")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codPrato;
    private char statusPrato;
    private String ingredientes;
    private String nomePrato;
    private BigDecimal valorItem;

    @OneToMany(mappedBy = "cardapio")
    private List<SaidaEstoque> saidaEstoques;
}
