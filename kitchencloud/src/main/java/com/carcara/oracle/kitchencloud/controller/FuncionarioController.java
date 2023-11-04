package com.carcara.oracle.kitchencloud.controller;


import com.carcara.oracle.kitchencloud.model.Comanda;
import com.carcara.oracle.kitchencloud.model.Funcionario;
import com.carcara.oracle.kitchencloud.model.Nota;
import com.carcara.oracle.kitchencloud.model.dto.CalculoAtendimentosDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoFuncionarioDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoNotaDTO;
import com.carcara.oracle.kitchencloud.model.dto.MediaAvaliacaoPorFuncionarioDTO;
import com.carcara.oracle.kitchencloud.service.FuncionarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
@Tag(name = "FUNCIONARIO")
@CrossOrigin
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    @GetMapping("total-atendimentos/{codFuncionario}")
    public ResponseEntity<CalculoAtendimentosDTO> calculoTotalAtendimentos (@PathVariable Long codFuncionario,
                                                                            @RequestParam LocalDateTime data1,
                                                                            @RequestParam LocalDateTime data2){
        return ResponseEntity.ok(funcionarioService.calculoTotalAtendimentos(codFuncionario,data1,data2));
    }

    @GetMapping
    public ResponseEntity<List<ExibicaoFuncionarioDTO>> listarFuncionarios(){
        return ResponseEntity.ok(funcionarioService.listarFuncionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExibicaoFuncionarioDTO> buscarFuncionario(@PathVariable Long id){
        ExibicaoFuncionarioDTO funcionarioDTO = funcionarioService.buscarFuncionario(id);
        return ResponseEntity.ok().body(funcionarioDTO);
    }

    @GetMapping("/total-atendimentos")
    public Map<String, Double> calculoRendimento(@RequestParam LocalDateTime data1, @RequestParam LocalDateTime data2){
        return funcionarioService.calculoRendimento(data1, data2);
    }

    @GetMapping("/avaliacao/{codFuncionario}")
    public List<ExibicaoNotaDTO> avaliacoesFuncionario(@PathVariable(value = "codFuncionario") Long codFuncionario){
        return funcionarioService.avaliacoesFuncionario(codFuncionario);
    }
    @GetMapping("/media-notas/{dataAvaliacaoIni}/{dataAvaliacaoFin}")
    public List<MediaAvaliacaoPorFuncionarioDTO> mediaAvaliacaoPorFuncionarioDTOS (
            @PathVariable LocalDateTime dataAvaliacaoIni,
            @PathVariable LocalDateTime dataAvaliacaoFin
    ){
        return funcionarioService.calculoMediaAvalicaoPorFuncionarioPorPeriodo(null,dataAvaliacaoIni, dataAvaliacaoFin);
    }
    @GetMapping("/media-notas/{dataAvaliacaoIni}/{dataAvaliacaoFin}/{idFuncionario}")
    public List<MediaAvaliacaoPorFuncionarioDTO> mediaAvaliacaoPorFuncionarioIndividual(
            @PathVariable LocalDateTime dataAvaliacaoIni,
            @PathVariable LocalDateTime dataAvaliacaoFin,
            @PathVariable Long idFuncionario
    ){
        return funcionarioService.calculoMediaAvalicaoPorFuncionarioPorPeriodo(idFuncionario,dataAvaliacaoIni, dataAvaliacaoFin);
    }
}
