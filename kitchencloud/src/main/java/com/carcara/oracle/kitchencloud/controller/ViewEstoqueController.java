package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.model.ViewEstoque;
import com.carcara.oracle.kitchencloud.service.ViewEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/view-estoque")
@CrossOrigin
public class ViewEstoqueController {

    @Autowired
    private ViewEstoqueService viewEstoqueService;

    @PostMapping("/teste")
    public ResponseEntity<String> teste(String string){
        return ResponseEntity.ok().body(string);
    }

    @GetMapping
    public ResponseEntity<List<ViewEstoque>> listarViewEstoque(){
        return ResponseEntity.ok().body(viewEstoqueService.listarViewEstoque());
    }
}
