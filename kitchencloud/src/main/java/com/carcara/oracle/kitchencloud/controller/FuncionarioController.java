package com.carcara.oracle.kitchencloud.controller;


import com.carcara.oracle.kitchencloud.model.Comanda;
import com.carcara.oracle.kitchencloud.model.Funcionario;
import com.carcara.oracle.kitchencloud.model.dto.CalculoAtendimentosDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoFuncionarioDTO;
import com.carcara.oracle.kitchencloud.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


import java.time.LocalDateTime;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    @GetMapping("total-atendimentos/{codFuncionario}/{data1}/{data2}")
    public ResponseEntity<CalculoAtendimentosDTO> calculoTotalAtendimentos (@PathVariable Long codFuncionario, @PathVariable LocalDateTime data1,
                                                               @PathVariable LocalDateTime data2){
        return ResponseEntity.ok(funcionarioService.calculoTotalAtendimentos(codFuncionario,data1,data2));
    }

    @GetMapping
    public ResponseEntity<List<ExibicaoFuncionarioDTO>> listarFuncionarios(){
        return ResponseEntity.ok(funcionarioService.listarFuncionarios());
    }


}
