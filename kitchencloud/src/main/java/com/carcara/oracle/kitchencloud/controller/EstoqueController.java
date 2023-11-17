package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.model.Estoque;
import com.carcara.oracle.kitchencloud.model.dto.CadastroEstoqueDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoEstoqueDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoSaidaEstoqueDTO;
import com.carcara.oracle.kitchencloud.model.dto.SaidaEstoqueDTO;
import com.carcara.oracle.kitchencloud.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("estoque")
@CrossOrigin
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping("entrada")
    public ExibicaoEstoqueDTO insercaoInsumoEstoque(@RequestBody CadastroEstoqueDTO cadastroEstoqueDTO){
        return estoqueService.insercaoInsumoEstoque(cadastroEstoqueDTO);
    }

    @PostMapping("saida")
    public ExibicaoSaidaEstoqueDTO saidaInsumoEstoque (@RequestBody SaidaEstoqueDTO saidaEstoqueDTO){
        return estoqueService.saidaInsumoEstoque(saidaEstoqueDTO);
    }

    @GetMapping("procurar-estoque-validade/{validade}")
    public List<ExibicaoEstoqueDTO> procurarEstoquePorDataValidade(@DateTimeFormat @PathVariable LocalDate validade){
        return estoqueService.procurarEstoquePorDataValidadeDto(validade);
    }
}
