package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.model.dto.ExibicaoPainelFornecedorDTO;
import com.carcara.oracle.kitchencloud.service.FornecedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
@Tag(name = "FORNECEDOR")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Operation(summary = "Mostra um fornecedor pelo id")
    @GetMapping("/{idFornecedor}")
    public ExibicaoPainelFornecedorDTO painelFornecedor(@PathVariable(value = "idFornecedor") Long idFornecedor){
        return fornecedorService.exibirPainelFornecedor(idFornecedor);
    }

    @Operation(summary = "Mostra o painel de todos fornecedores")
    @GetMapping
    public List<ExibicaoPainelFornecedorDTO> painelFornecedores(){
        return fornecedorService.exibirFornecedores();
    }

}
