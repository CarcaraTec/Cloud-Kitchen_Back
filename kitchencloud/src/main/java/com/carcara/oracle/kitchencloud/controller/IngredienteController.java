package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.model.Ingrediente;
import com.carcara.oracle.kitchencloud.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingrediente")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @PostMapping("estoque-minimo")
    public Ingrediente definirEstoqueMinimo(Long codIngrediente, Float estoqueMinimo){
        return ingredienteService.definirEstoqueMinimo(codIngrediente,estoqueMinimo);
    }
}
