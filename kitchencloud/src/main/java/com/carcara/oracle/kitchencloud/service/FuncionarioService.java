package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.Comanda;
import com.carcara.oracle.kitchencloud.model.Funcionario;
import com.carcara.oracle.kitchencloud.model.dto.CalculoAtendimentosDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoFuncionarioDTO;
import com.carcara.oracle.kitchencloud.repository.ComandaRepository;
import com.carcara.oracle.kitchencloud.repository.FolgaRepository;
import com.carcara.oracle.kitchencloud.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ComandaRepository comandaRepository;

    public List<ExibicaoFuncionarioDTO> listarFuncionarios(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(funcionario -> new ExibicaoFuncionarioDTO(funcionario)).toList();
    }

    public CalculoAtendimentosDTO calculoTotalAtendimentos(Long codFuncionario, LocalDateTime data1, LocalDateTime data2) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(codFuncionario);
        if(funcionario.isEmpty()){

        }
        Long atendimentosRealizados = comandaRepository.countByFuncionarioAndHorarioAberturaBetween(funcionario.get(), data1, data2);
        Long atendimentosTotal = comandaRepository.countByHorarioAberturaBetween(data1, data2);
        Long dias = ChronoUnit.DAYS.between(data1, data2);
        return new CalculoAtendimentosDTO(dias,atendimentosTotal,atendimentosRealizados);
    }
}
