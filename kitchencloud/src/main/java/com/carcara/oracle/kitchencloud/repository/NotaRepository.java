package com.carcara.oracle.kitchencloud.repository;

import com.carcara.oracle.kitchencloud.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

    List<Nota> findByFuncionarioCodFuncionario(Long codFuncionario);
}
