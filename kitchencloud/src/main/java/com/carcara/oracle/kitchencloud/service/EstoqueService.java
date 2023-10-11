package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.Estoque;
import com.carcara.oracle.kitchencloud.model.ItemCompra;
import com.carcara.oracle.kitchencloud.model.dto.CadastroEstoqueDTO;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoEstoqueDTO;
import com.carcara.oracle.kitchencloud.repository.EstoqueRepository;
import com.carcara.oracle.kitchencloud.repository.ItemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ItemCompraRepository itemCompraRepository;

    public ExibicaoEstoqueDTO insercaoInsumoEstoque(CadastroEstoqueDTO cadastroEstoqueDTO){
        Optional<ItemCompra> itemCompra = itemCompraRepository.findById(cadastroEstoqueDTO.codItemCompra());

        if (itemCompra.isEmpty()){

        }
        Estoque estoque = new Estoque(cadastroEstoqueDTO,itemCompra.get());

        estoqueRepository.save(estoque);
        return new ExibicaoEstoqueDTO(estoque);
    }
}
