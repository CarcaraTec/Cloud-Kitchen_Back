package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.ConfiguracaoAlerta;
import com.carcara.oracle.kitchencloud.model.EnvioEmail;
import com.carcara.oracle.kitchencloud.model.Estoque;
import com.carcara.oracle.kitchencloud.model.Ingrediente;
import com.carcara.oracle.kitchencloud.model.dto.CadastroConfiguracaoAlertaDTO;
import com.carcara.oracle.kitchencloud.model.enums.Entidade;
import com.carcara.oracle.kitchencloud.repository.ConfiguracaoAlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracaoAlertaService {

    @Autowired
    private ConfiguracaoAlertaRepository configuracaoAlertaRepository;

    @Autowired
    private RestTemplateEmailService restTemplateEmailService;

    public ConfiguracaoAlerta criarAlerta (CadastroConfiguracaoAlertaDTO cadastroConfiguracaoAlertaDTO){
        ConfiguracaoAlerta configuracaoAlerta = new ConfiguracaoAlerta(cadastroConfiguracaoAlertaDTO);

        Integer firstId = configuracaoAlertaRepository.findFirstByOrderByIdDesc();

        configuracaoAlerta.setId(firstId != null ? firstId : 1);
        return configuracaoAlertaRepository.save(configuracaoAlerta);
    }

    public List<ConfiguracaoAlerta> procurarAlertaEstoque (){
        return configuracaoAlertaRepository.findByEntidade(Entidade.ESTOQUE);
    }

    public void alertaEstoque(Estoque estoque, ConfiguracaoAlerta configuracaoAlerta){
        EnvioEmail envioEmail = new EnvioEmail();
        switch (configuracaoAlerta.getCondicaoDisparo()){
            case QUANTIDADE_EM_ESTOQUE -> {
                Ingrediente ingrediente = estoque.getItemCompra().getIngrediente();
                if(estoque.getItemCompra().getIngrediente().getQuantidadeTotal()/
                        estoque.getItemCompra().getIngrediente().getEstoqueMinimo()
                        > Double.valueOf(configuracaoAlerta.getValorParametro())){
                    envioEmail = EnvioEmail.builder()
                            .para(configuracaoAlerta.getDestinatarios())
                                    .assunto("Alerta estoque")
                                            .conteudo("<h1>Aviso de Estoque Mínimo</h1>\n" +
                                                    "\n" +
                                                    "    <p>Olá,</p>\n" +
                                                    "\n" +
                                                    "    <p>Este é um aviso para informar que o estoque do item <strong>"+ingrediente.getNomeIngrediente()+"</strong> está abaixo do nível mínimo. A quantidade disponível atualmente é insuficiente para atender à demanda esperada.</p>\n" +
                                                    "\n" +
                                                    "    <p>Por favor, tome as medidas necessárias para reabastecer o estoque deste item o mais rápido possível.</p>\n" +
                                                    "\n" +
                                                    "    <p>Lembre-se de que a disponibilidade dos produtos em estoque é crucial para garantir um bom atendimento aos nossos clientes e evitar a interrupção das operações.</p>\n" +
                                                    "\n" +
                                                    "    <p>Se você tiver alguma dúvida ou precisar de assistência adicional, não hesite em entrar em contato conosco.</p>\n" +
                                                    "\n" +
                                                    "    <p>Obrigado pela atenção e ação imediata.</p>\n" +
                                                    "\n" +
                                                    "    <p>Atenciosamente,<br>")
                                                    .build();
                    restTemplateEmailService.enviarEmailSimples(envioEmail);
                }
            }
        }
    }
}
