package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/calculos")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;

    @GetMapping("/preco-medio-nota")
    public BigDecimal calcularPrecoMedioNota(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {

        return calculoService.calculoPrecoMedioNota(dataInicio, dataFim);
    }

    @GetMapping("/receita-total")
    public BigDecimal calcularReceitaTotal(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim) {

        return calculoService.calculoReceitaTotal(dataInicio, dataFim);
    }

}
