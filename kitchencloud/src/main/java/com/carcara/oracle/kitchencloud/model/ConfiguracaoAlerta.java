package com.carcara.oracle.kitchencloud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguracaoAlerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_alerta")
    private String nomeAlerta;

    private String descricao;
    private String entidade;
    
    @Column(name = "condicao_disparo")
    private String condicaoDisparo;
    
    @Column(name = "valor_parametro")
    private String valorParametro;
    private String acao;
    private String destinatarios;
    
    @Column(name = "ativo")
    private Integer ativo;

    // Getters and setters (ou Lombok @Data) e outros métodos, construtores, etc.

}