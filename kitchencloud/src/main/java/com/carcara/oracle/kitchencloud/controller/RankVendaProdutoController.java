package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.model.RankVendaProduto;
import com.carcara.oracle.kitchencloud.service.RankVendaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankVendaProdutoController {

    @Autowired
    private RankVendaProdutoService rankVendaProdutoService;

    @GetMapping
    public List<RankVendaProduto> rankVendaProdutos(@RequestParam String data1, @RequestParam String data2, @RequestParam Integer diaSemana) {
        return rankVendaProdutoService.rankVendaProdutos(diaSemana,data1, data2);
    }
}
