package com.carcara.oracle.kitchencloud.repository;

import com.carcara.oracle.kitchencloud.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {
}
