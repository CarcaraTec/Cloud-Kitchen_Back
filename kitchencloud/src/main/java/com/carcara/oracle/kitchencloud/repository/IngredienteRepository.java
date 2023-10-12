package com.carcara.oracle.kitchencloud.repository;

import com.carcara.oracle.kitchencloud.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente,Long> {
}
