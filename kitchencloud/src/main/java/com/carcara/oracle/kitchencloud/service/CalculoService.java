package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.exception.SolicitacaoNaoEncontrada;
import com.carcara.oracle.kitchencloud.model.Comanda;
import com.carcara.oracle.kitchencloud.model.ItemVendaDiaria;
import com.carcara.oracle.kitchencloud.model.VendaDiaria;
import com.carcara.oracle.kitchencloud.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

        final BigDecimal[] total = {valorTotal}; // Criar um array de BigDecimal

        comandas.forEach(comanda -> {
            BigDecimal valor = comanda.getVendaDiaria().getTotalPagamento();
            System.out.println(valor);
            total[0] = valor.add(total[0]); // Atualizar o valor do array
        });

        return total[0].divide(BigDecimal.valueOf(quantidadeNotas));
    }

}
