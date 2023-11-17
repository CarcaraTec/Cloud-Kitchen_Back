package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.dto.ExibicaoProdutosVendidos;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoRankPratoDTO;
import com.carcara.oracle.kitchencloud.repository.CardapioRepository;
import com.carcara.oracle.kitchencloud.repository.ItemVendaDiariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PratoService {

    @Autowired
    private CardapioRepository cardapioRepository;
    @Autowired
    private ItemVendaDiariaRepository itemVendaDiariaRepository;

    public ExibicaoProdutosVendidos maisVendidos(){
        List<ExibicaoRankPratoDTO> pratosPrincipaisMaisVendidos = pratosPrincipaisMaisVendidos();
        List<ExibicaoRankPratoDTO> sobremesasMaisVendidos = sobremesasMaisVendidos();
        List<ExibicaoRankPratoDTO> bebidasMaisVendidos = bebidasMaisVendidos();

        return new ExibicaoProdutosVendidos(pratosPrincipaisMaisVendidos, sobremesasMaisVendidos, bebidasMaisVendidos);
    }

    public List<ExibicaoRankPratoDTO> pratosPrincipaisMaisVendidos() {
        List<Object[]> itemVendaDiarias = itemVendaDiariaRepository.pratosPrincipaisMaisVendidos();
        List<ExibicaoRankPratoDTO> exibicaoRankPratoDTO = new ArrayList<>();

        exibicaoRankPratoDTO = itemVendaDiarias.stream()
                .map(item -> new ExibicaoRankPratoDTO(
                        (String) item[0],
                        ((Number) item[1]).intValue()
                ))
                .collect(Collectors.toList());

        return exibicaoRankPratoDTO;
    }

    public List<ExibicaoRankPratoDTO> sobremesasMaisVendidos() {
        List<Object[]> itemVendaDiarias = itemVendaDiariaRepository.sobremesasMaisVendidas();
        List<ExibicaoRankPratoDTO> exibicaoRankPratoDTO = new ArrayList<>();

        exibicaoRankPratoDTO = itemVendaDiarias.stream()
                .map(item -> new ExibicaoRankPratoDTO(
                        (String) item[0],
                        ((Number) item[1]).intValue()
                ))
                .collect(Collectors.toList());

        return exibicaoRankPratoDTO;
    }

    public List<ExibicaoRankPratoDTO> bebidasMaisVendidos() {
        List<Object[]> itemVendaDiarias = itemVendaDiariaRepository.bebidasMaisVendidas();
        List<ExibicaoRankPratoDTO> exibicaoRankPratoDTO = new ArrayList<>();

        exibicaoRankPratoDTO = itemVendaDiarias.stream()
                .map(item -> new ExibicaoRankPratoDTO(
                        (String) item[0],
                        ((Number) item[1]).intValue()
                ))
                .collect(Collectors.toList());

        return exibicaoRankPratoDTO;
    }

}
