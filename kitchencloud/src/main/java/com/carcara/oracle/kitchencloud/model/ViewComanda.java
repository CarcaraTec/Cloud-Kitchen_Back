package com.carcara.oracle.kitchencloud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "view_dados_venda")
public class ViewComanda {

    @Id
    private Long idComanda;

    @JsonProperty("quantidadeItenNota")
    private Integer quantidadeItemVenda;

    @JsonProperty("faturamentoNota")
    private BigDecimal totalPagamentoVenda;

    @JsonProperty("horarioAberturaPedido")
    private LocalDateTime horarioAberturaComanda;

    @JsonProperty("horarioFechamentoPedido")
    private LocalDateTime horarioFechamentoComanda;

    @JsonProperty("funcionarioAtendente")
    private String nomeFuncionario;
}
