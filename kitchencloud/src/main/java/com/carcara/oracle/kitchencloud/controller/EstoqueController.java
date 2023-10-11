package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.model.dto.CadastroEstoqueDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoEstoqueDTO;
import com.carcara.oracle.kitchencloud.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    private ExibicaoEstoqueDTO insercaoInsumoEstoque(@RequestBody CadastroEstoqueDTO cadastroEstoqueDTO){
        return estoqueService.insercaoInsumoEstoque(cadastroEstoqueDTO);
    }
}
