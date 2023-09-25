package com.carcara.oracle.kitchencloud.repository;

import com.carcara.oracle.kitchencloud.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
