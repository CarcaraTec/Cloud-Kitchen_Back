package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.Cardapio;
import com.carcara.oracle.kitchencloud.model.Estoque;
import com.carcara.oracle.kitchencloud.model.ItemCompra;
import com.carcara.oracle.kitchencloud.model.SaidaEstoque;
import com.carcara.oracle.kitchencloud.model.dto.CadastroEstoqueDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoEstoqueDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoSaidaEstoqueDTO;
import com.carcara.oracle.kitchencloud.model.dto.SaidaEstoqueDTO;
import com.carcara.oracle.kitchencloud.repository.CardapioRepository;
import com.carcara.oracle.kitchencloud.repository.EstoqueRepository;
import com.carcara.oracle.kitchencloud.repository.ItemCompraRepository;
import com.carcara.oracle.kitchencloud.repository.SaidaEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ItemCompraRepository itemCompraRepository;

    @Autowired
    private SaidaEstoqueRepository saidaEstoqueRepository;

    @Autowired
    private CardapioRepository cardapioRepository;

    public ExibicaoEstoqueDTO insercaoInsumoEstoque(CadastroEstoqueDTO cadastroEstoqueDTO){
        Optional<ItemCompra> itemCompra = itemCompraRepository.findById(cadastroEstoqueDTO.codItemCompra());
 
        if (itemCompra.isEmpty()){

        }
        Estoque estoque = new Estoque(cadastroEstoqueDTO,itemCompra.get());

        estoqueRepository.save(estoque);
        return new ExibicaoEstoqueDTO(estoque);
    }

    public ExibicaoSaidaEstoqueDTO saidaInsumoEstoque(SaidaEstoqueDTO saidaEstoqueDTO){
        Optional<Estoque> estoque = estoqueRepository.findById(saidaEstoqueDTO.codEstoque());
        if(estoque.isEmpty()){
            // AQUI COLOCAR EXCESSÃO
        }
        Optional<Cardapio> cardapio = cardapioRepository.findById(saidaEstoqueDTO.codPrato());
        if(cardapio.isEmpty()){
            // AQUI COLOCAR EXCESSÃO
        }
        SaidaEstoque saidaEstoque = new SaidaEstoque(saidaEstoqueDTO,estoque.get(),cardapio.get());

        saidaEstoque.setCodSaida(saidaEstoqueRepository.findFirstByOrderByIdDesc());
        saidaEstoqueRepository.save(saidaEstoque);
        return new ExibicaoSaidaEstoqueDTO(saidaEstoque);
    }
}
