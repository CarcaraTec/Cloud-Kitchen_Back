package com.carcara.oracle.kitchencloud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "v_estoque")
public class ViewEstoque {

    @Id
    private Long codIngrediente;
    private String nomeIngrediente;
    private String unidadeMedida;
    private String categoriaIngrediente;
    private Integer quantidade;
    private Integer capacidade;
    private Integer estoqueMinimo;

}
