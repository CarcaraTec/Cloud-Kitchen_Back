package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.Funcionario;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoFuncionarioDTO;
import com.carcara.oracle.kitchencloud.repository.FolgaRepository;
import com.carcara.oracle.kitchencloud.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<ExibicaoFuncionarioDTO> listarFuncionarios(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(funcionario -> new ExibicaoFuncionarioDTO(funcionario)).toList();
    }
}
