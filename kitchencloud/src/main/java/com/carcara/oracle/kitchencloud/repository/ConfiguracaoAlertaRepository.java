package com.carcara.oracle.kitchencloud.repository;

import com.carcara.oracle.kitchencloud.model.ConfiguracaoAlerta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracaoAlertaRepository extends JpaRepository<ConfiguracaoAlerta, Long> {
}