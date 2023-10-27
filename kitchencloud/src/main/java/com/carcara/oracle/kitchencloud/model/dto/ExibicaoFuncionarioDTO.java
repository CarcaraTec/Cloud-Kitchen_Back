package com.carcara.oracle.kitchencloud.model.dto;

import com.carcara.oracle.kitchencloud.model.Funcionario;

import java.time.LocalDateTime;
import java.util.List;

public record ExibicaoFuncionarioDTO(Long id, String nome, String funcao, List<LocalDateTime> diaFolga) {

    public ExibicaoFuncionarioDTO(Funcionario funcionario){
        this(funcionario.getCodFuncionario(),
                funcionario.getNomeFuncionario(),
                funcionario.getCargo(),
                funcionario.getFolgas().stream().map(folga -> folga.getDataFolga()).toList());
    }
}
