package com.carcara.oracle.kitchencloud.repository;

import com.carcara.oracle.kitchencloud.model.ViewVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewVendasRepository extends JpaRepository<ViewVendas, Long> {
}
