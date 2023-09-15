package com.carcara.oracle.kitchencloud.model;

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
@Table(name = "tb_compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCompra;

    private LocalDate dataCompra;
    private String statusCompra;
    private Double valorCompra;

    @ManyToOne
    @JoinColumn(name = "cod_fornecedor")
    private Fornecedor fornecedor;

    @OneToMany(mappedBy = "compra")
    private List<ItemCompra> itensCompra;
}
