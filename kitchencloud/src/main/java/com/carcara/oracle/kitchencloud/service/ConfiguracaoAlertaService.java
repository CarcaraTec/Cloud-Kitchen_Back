package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.ConfiguracaoAlerta;
import com.carcara.oracle.kitchencloud.model.dto.CadastroConfiguracaoAlertaDTO;
import com.carcara.oracle.kitchencloud.repository.ConfiguracaoAlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracaoAlertaService {

    @Autowired
    private ConfiguracaoAlertaRepository configuracaoAlertaRepository;

    public ConfiguracaoAlerta criarAlerta (CadastroConfiguracaoAlertaDTO cadastroConfiguracaoAlertaDTO){
        ConfiguracaoAlerta configuracaoAlerta = new ConfiguracaoAlerta(cadastroConfiguracaoAlertaDTO);
        configuracaoAlerta.setId(configuracaoAlertaRepository.findFirstByOrderByIdDesc()+1);;
        return configuracaoAlertaRepository.save(configuracaoAlerta);
    }

    public void teste(){

    }
}
