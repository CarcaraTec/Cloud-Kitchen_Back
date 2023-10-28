package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.Comanda;
import com.carcara.oracle.kitchencloud.model.Funcionario;
import com.carcara.oracle.kitchencloud.model.dto.CalculoAtendimentosDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoFuncionarioDTO;
import com.carcara.oracle.kitchencloud.repository.ComandaRepository;
import com.carcara.oracle.kitchencloud.repository.FuncionarioRepository;
import jdk.jfr.Percentage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ComandaRepository comandaRepository;

    public List<ExibicaoFuncionarioDTO> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(funcionario -> new ExibicaoFuncionarioDTO(funcionario)).toList();
    }

    public CalculoAtendimentosDTO calculoTotalAtendimentos(Long codFuncionario, LocalDateTime data1, LocalDateTime data2) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(codFuncionario);
        if (funcionario.isEmpty()) {
        }
        Long atendimentosRealizados = comandaRepository.countByFuncionarioAndHorarioAberturaBetween(funcionario.get(), data1, data2);
        Long atendimentosTotal = comandaRepository.countByHorarioAberturaBetween(data1, data2);
        Long dias = ChronoUnit.DAYS.between(data1, data2);
        return new CalculoAtendimentosDTO(dias, atendimentosTotal, atendimentosRealizados);
    }

    public Map<String, Double> calculoRendimento(LocalDateTime data1, LocalDateTime data2) {
        if (data1 == null && data2 == null) {
            // trazer dos últimos 30 dias
            // LocalDate.now().minusDays(30)
        } else if (data1 != null && data2 == null) {
            // trazer apenas do dia passado no data1
        }

        List<Comanda> comandas = comandaRepository.findByHorarioAberturaBetween(data1, data2);
        Integer totalComandas = comandas.size();

        Map<String, Integer> quantidadeAtendimentoFunc = new HashMap();

        for (Comanda comanda : comandas) {
            String nomeFuncionario = comanda.getFuncionario().getNomeFuncionario();
            quantidadeAtendimentoFunc.put(nomeFuncionario, quantidadeAtendimentoFunc.getOrDefault(nomeFuncionario, 0) + 1);
        }

        Map<String, Double> porcentagemAtendimentoFunc = new HashMap();

        for (String funcionario : quantidadeAtendimentoFunc.keySet()) {
            int atendimentosFuncionario = quantidadeAtendimentoFunc.get(funcionario);
            double porcentagem = (double) atendimentosFuncionario / totalComandas * 100;
            porcentagemAtendimentoFunc.put(funcionario, porcentagem);
        }

        return porcentagemAtendimentoFunc;
    }

}
