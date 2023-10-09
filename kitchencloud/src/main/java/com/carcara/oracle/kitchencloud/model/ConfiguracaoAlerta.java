package com.carcara.oracle.kitchencloud.model;

import com.carcara.oracle.kitchencloud.model.dto.CadastroConfiguracaoAlertaDTO;
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
    @Column(name = "ID")
    private Integer id;

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

    public ConfiguracaoAlerta(CadastroConfiguracaoAlertaDTO cadastroConfiguracaoAlertaDTO) {
        this.nomeAlerta = cadastroConfiguracaoAlertaDTO.nomeAlerta();
        this.descricao = cadastroConfiguracaoAlertaDTO.descricao();
        this.entidade = cadastroConfiguracaoAlertaDTO.entidade();
        this.condicaoDisparo = cadastroConfiguracaoAlertaDTO.condicaoDisparo();
        this.valorParametro = cadastroConfiguracaoAlertaDTO.valorParametro();
        this.acao = cadastroConfiguracaoAlertaDTO.acao();
        this.destinatarios = cadastroConfiguracaoAlertaDTO.destinatarios();
        this.ativo = 1;
    }

    // Getters and setters (ou Lombok @Data) e outros métodos, construtores, etc.

}