package com.carcara.oracle.kitchencloud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_saida_estoque")
public class SaidaEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codSaida;
    private Integer quantidadeSaida;
    private LocalDate dataSaida;
    private String motivoSaida;

    @ManyToOne
    @JoinColumn(name = " cod_estoque")
    private Estoque estoque;

    @ManyToOne
    @JoinColumn(name = " cod_prato")
    private Cardapio cardapio;
}
