package com.carcara.oracle.kitchencloud.repository;

import com.carcara.oracle.kitchencloud.model.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long> {
}
