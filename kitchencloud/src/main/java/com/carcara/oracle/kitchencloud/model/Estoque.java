package com.carcara.oracle.kitchencloud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEstoque;
    private Integer pesoProduto;
    private Integer quantidadeProduto;
    private LocalDate dataEntrada;
    private LocalDate dataValidade;
    private Integer capacidade;
    private Integer estoqueMinimo;

    @OneToMany(mappedBy = "estoque")
    private List<SaidaEstoque> saidaEstoques;

    @ManyToOne
    @JoinColumn(name = "cod_item_compra")
    private ItemCompra itemCompra;

}
