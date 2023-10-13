package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.model.dto.CadastroCompraDTO;
import com.carcara.oracle.kitchencloud.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public void cadastrarCompra(@RequestBody CadastroCompraDTO cadastroCompraDTO){
        compraService.cadastrarCompra(cadastroCompraDTO);
    }

}
