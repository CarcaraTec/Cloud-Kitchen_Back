package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.model.dto.CalculoDTO;
import com.carcara.oracle.kitchencloud.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/painel-receitas")
public class CalculoController {

    @Autowired
    private CalculoService calculoService;



    @GetMapping
    public ResponseEntity<CalculoDTO> painelReceitas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim){

        CalculoDTO calculoPainelReceita = calculoService.calculoPainelReceitas(dataInicio, dataFim);
        return ResponseEntity.ok().body(calculoPainelReceita);
    }
}
