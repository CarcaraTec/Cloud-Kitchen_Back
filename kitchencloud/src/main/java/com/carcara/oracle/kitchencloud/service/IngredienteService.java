package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.Ingrediente;
import com.carcara.oracle.kitchencloud.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;
    public Ingrediente definirEstoqueMinimo(Long codIngrediente, Float estoqueMinimo) {
        Optional<Ingrediente> ingrediente = ingredienteRepository.findById(codIngrediente);
        if(ingrediente.isEmpty()){
            // EXCESSÃO AQUI
        }
        ingrediente.get().setEstoqueMinimo(estoqueMinimo);
        ingredienteRepository.save(ingrediente.get());
        return ingrediente.get();
    }

    public List<Ingrediente> listarTodosIngredientes() {
        return ingredienteRepository.findAll();
    }
}
