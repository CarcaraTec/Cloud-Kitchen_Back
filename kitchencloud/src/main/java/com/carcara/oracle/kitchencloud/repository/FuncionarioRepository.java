package com.carcara.oracle.kitchencloud.repository;

import com.carcara.oracle.kitchencloud.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
