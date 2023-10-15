package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.ConfiguracaoAlerta;
import com.carcara.oracle.kitchencloud.model.Estoque;
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
        configuracaoAlerta.setId(configuracaoAlertaRepository.findFirstByOrderByIdDesc()+1);
        return configuracaoAlertaRepository.save(configuracaoAlerta);
    }

    public void alertaEstoque(Estoque estoque, ConfiguracaoAlerta configuracaoAlerta){
        switch (configuracaoAlerta.getCondicaoDisparo()){
            case QUANTIDADE_EM_ESTOQUE -> {
                if(estoque.getItemCompra().getIngrediente().getQuantidadeTotal()/
                        estoque.getItemCompra().getIngrediente().getEstoqueMinimo()
                        > Double.valueOf(configuracaoAlerta.getValorParametro())){
                    System.out.println("entrou");
                }
            }
        }
    }
}
