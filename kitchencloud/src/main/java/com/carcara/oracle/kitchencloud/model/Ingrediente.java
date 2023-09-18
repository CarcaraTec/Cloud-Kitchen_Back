package com.carcara.oracle.kitchencloud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_ingredientes")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codIngrediente;

    private String unidadeMedida;
    private String categoriaIngrediente;
    private String nomeIngrediente;

    @ManyToOne
    @JoinColumn(name = "cod_item_compra")
    private ItemCompra itemCompra;

    @ManyToOne
    @JoinColumn(name = "cod_estoque")
    private Estoque estoque;

}
