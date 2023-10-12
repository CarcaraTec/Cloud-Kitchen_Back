package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.exception.SolicitacaoNaoEncontrada;
import com.carcara.oracle.kitchencloud.model.Comanda;
import com.carcara.oracle.kitchencloud.model.ItemVendaDiaria;
import com.carcara.oracle.kitchencloud.model.VendaDiaria;
import com.carcara.oracle.kitchencloud.model.dto.CalculoDTO;
import com.carcara.oracle.kitchencloud.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CalculoService {

    @Autowired
    private ComandaRepository comandaRepository;

    public BigDecimal calculoPrecoMedioNota(LocalDateTime dataInicio, LocalDateTime dataFim){
        List<Comanda> comandas = comandaRepository.findByHorarioAberturaBetween(dataInicio, dataFim);
        BigDecimal valorTotal = new BigDecimal("0.0");
        Integer quantidadeNotas = comandas.size();

        final BigDecimal[] total = {valorTotal};

        comandas.forEach(comanda -> {
            BigDecimal valor = comanda.getVendaDiaria().getTotalPagamento();
            total[0] = valor.add(total[0]);
        });

        return total[0].divide(BigDecimal.valueOf(quantidadeNotas));
    }

    public BigDecimal calculoReceitaTotal(LocalDateTime dataInicio, LocalDateTime dataFim){
        List<Comanda> comandas = comandaRepository.findByHorarioAberturaBetween(dataInicio, dataFim);
        BigDecimal valorTotal = new BigDecimal("0.0");

        final BigDecimal[] total = {valorTotal};

        comandas.forEach(comanda -> {
            BigDecimal valor = comanda.getVendaDiaria().getTotalPagamento();
            total[0] = valor.add(total[0]);
        });
        return total[0];
    }

    public Duration calculoParmaneciaMedia(LocalDateTime dataInicio, LocalDateTime dataFim) {
        List<Comanda> comandas = comandaRepository.findByHorarioAberturaBetween(dataInicio, dataFim);

        Duration duracaoTotal = Duration.ZERO;

        for (Comanda comanda : comandas) {
            Timestamp abertura = comanda.getHorarioAbertura();
            Timestamp fechamento = comanda.getHorarioFechamento();

            LocalDateTime aberturaLocalDateTime = abertura.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime fechamentoLocalDateTime = fechamento.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            Duration duracaoComanda = Duration.between(aberturaLocalDateTime, fechamentoLocalDateTime);

            duracaoTotal = duracaoTotal.plus(duracaoComanda);
        }

        Integer numeroDeComandas = comandas.size();
        if (numeroDeComandas > 0) {
            return duracaoTotal.dividedBy(numeroDeComandas);
        } else {
            return Duration.ZERO;
        }
    }

    public Integer quantidadeNotas(LocalDateTime dataInicio, LocalDateTime dataFim){
        List<Comanda> comandas = comandaRepository.findByHorarioAberturaBetween(dataInicio, dataFim);
        return comandas.size();
    }

    public CalculoDTO calculoPainelReceitas(LocalDateTime dataInicio, LocalDateTime dataFim){
        BigDecimal precoMedioNota = calculoPrecoMedioNota(dataInicio, dataFim);
        BigDecimal receitaTotal = calculoReceitaTotal(dataInicio, dataFim);
        Duration permancenciaMedia = calculoParmaneciaMedia(dataInicio, dataFim);
        Integer quantidadeNota = quantidadeNotas(dataInicio, dataFim);

        return new CalculoDTO(precoMedioNota, receitaTotal, permancenciaMedia, quantidadeNota);
    }

}
