package com.carcara.oracle.kitchencloud.service;


import com.carcara.oracle.kitchencloud.InformacoesMes;
import com.carcara.oracle.kitchencloud.config.JSONToPDF;
import com.carcara.oracle.kitchencloud.model.EnvioEmail;
import com.carcara.oracle.kitchencloud.model.RankVendaProduto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private RestTemplateEmailService restTemplateEmailService;

    @Autowired
    private RankVendaProdutoService rankVendaProdutoService;

    @Autowired
    private JSONToPDF jsonToPDF;

    public void rankPratosDiarios(EnvioEmail envioEmail) throws IOException {
        InformacoesMes informacoesMes = new InformacoesMes();
        List<RankVendaProduto> rankVendaProdutos =
                rankVendaProdutoService.rankVendaProdutos(informacoesMes.getNumeroDoDia(),
                        informacoesMes.getPrimeiroDiaDoMes().toString(),informacoesMes.getUltimoDiaDoMes().toString());

        jsonToPDF.criarPdf(informacoesMes.getNumeroDoDia(),
                informacoesMes.getPrimeiroDiaDoMes().toString(),informacoesMes.getUltimoDiaDoMes().toString());
        // Inicialize um StringBuilder para construir a tabela HTML
        StringBuilder tableHtml = new StringBuilder();

        // Adicione a tag de abertura da tabela
        tableHtml.append("<table border=\"1\">");

        // Adicione o cabeçalho da tabela
        // Adicione o cabeçalho da tabela com estilos CSS
        tableHtml.append("<tr><th style=\"background-color:#f2f2f2; font-size:16px;\">Código do Prato</th><th style=\"background-color:#f2f2f2; font-size:16px;\">Nome do Prato</th><th style=\"background-color:#f2f2f2; font-size:16px;\">Dia da Semana</th><th style=\"background-color:#f2f2f2; font-size:16px;\">Quantidade Total</th><th style=\"background-color:#f2f2f2; font-size:16px;\">Valor Total do Produto (em R$)</th><th style=\"background-color:#f2f2f2; font-size:16px;\">Impacto (%)</th></tr>");

// Adicione estilo às células da tabela
        for (RankVendaProduto produto : rankVendaProdutos) {
            tableHtml.append("<tr>");
            tableHtml.append("<td style=\"border: 1px solid #ccc; padding: 8px;\">").append(produto.getCodPrato()).append("</td>");
            tableHtml.append("<td style=\"border: 1px solid #ccc; padding: 8px;\">").append(produto.getNomePrato()).append("</td>");
            tableHtml.append("<td style=\"border: 1px solid #ccc; padding: 8px;\">").append(produto.getDiaDaSemana()).append("</td>");
            tableHtml.append("<td style=\"border: 1px solid #ccc; padding: 8px;\">").append(produto.getQuantidadeTotal()).append("</td>");
            tableHtml.append("<td style=\"border: 1px solid #ccc; padding: 8px;\">").append(produto.getValorTotalProduto()).append("</td>");
            tableHtml.append("<td style=\"border: 1px solid #ccc; padding: 8px;\">").append(produto.getImpactoPorcentagem()).append("%</td>");
            tableHtml.append("</tr>");
        }


        // Adicione a tag de fechamento da tabela
        tableHtml.append("</table>");

        // A string `tableHtml` agora contém a tabela HTML
        String tabelaHTML = tableHtml.toString();

        envioEmail.setConteudo(tabelaHTML);

        restTemplateEmailService.enviarPost(envioEmail);
    }


    public static List<RankVendaProduto> conteudoToRankVenda (String rankVendaProduto){
        Gson gson = new Gson();
        List<RankVendaProduto> lista = gson.fromJson(rankVendaProduto, new TypeToken<List<RankVendaProduto>>() {}.getType());
        return lista;
    }
}
