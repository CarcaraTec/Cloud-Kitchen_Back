package com.carcara.oracle.kitchencloud.model;

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
@Table(name = "tb_item_compra")
public class ItemCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codItemCompra;

    private char statusItem;
    private String descricaoItem;

    @ManyToOne
    @JoinColumn(name = "cod_compra")
    private Compra compra;

    @OneToMany(mappedBy = "itemCompra")
    private List<Ingrediente> ingredientes;
}
