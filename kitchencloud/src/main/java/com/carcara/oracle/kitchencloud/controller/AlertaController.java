package com.carcara.oracle.kitchencloud.controller;

import com.carcara.oracle.kitchencloud.model.ConfiguracaoAlerta;
import com.carcara.oracle.kitchencloud.model.dto.CadastroConfiguracaoAlertaDTO;
import com.carcara.oracle.kitchencloud.service.ConfiguracaoAlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerta")
public class AlertaController {

    @Autowired
    private ConfiguracaoAlertaService configuracaoAlertaService;

    @PostMapping
    public ConfiguracaoAlerta criarAlerta (@RequestBody CadastroConfiguracaoAlertaDTO configuracaoAlerta){
        return configuracaoAlertaService.criarAlerta(configuracaoAlerta);
    }

    @PostMapping("rotina-data")
    public List<ConfiguracaoAlerta> teste(){
        return configuracaoAlertaService.alertaData();
    }
}
