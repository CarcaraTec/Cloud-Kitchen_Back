package com.carcara.oracle.kitchencloud.repository;

import com.carcara.oracle.kitchencloud.model.Cardapio;
import com.carcara.oracle.kitchencloud.model.ItemVendaDiaria;
import com.carcara.oracle.kitchencloud.model.dto.ExibicaoRankPratoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemVendaDiariaRepository extends JpaRepository<ItemVendaDiaria, Long> {

    @Query(value = "SELECT c.nome_prato AS nome_prato, SUM(ivd.quantidade) AS quantidade\n" +
            "FROM tb_item_venda_diaria ivd\n" +
            "JOIN tb_cardapio c ON ivd.cod_prato = c.cod_prato\n" +
            "WHERE c.categoria = 'prato principal'\n" +
            "GROUP BY c.nome_prato\n" +
            "ORDER BY quantidade DESC\n" +
            "FETCH FIRST 3 ROWS ONLY", nativeQuery = true)
    List<Object[]> pratosPrincipaisMaisVendidos();

    @Query(value = "SELECT c.nome_prato AS nome_prato, SUM(ivd.quantidade) AS quantidade\n" +
            "FROM tb_item_venda_diaria ivd\n" +
            "JOIN tb_cardapio c ON ivd.cod_prato = c.cod_prato\n" +
            "WHERE c.categoria = 'sobremesa'\n" +
            "GROUP BY c.nome_prato\n" +
            "ORDER BY quantidade DESC\n" +
            "FETCH FIRST 3 ROWS ONLY", nativeQuery = true)
    List<Object[]> sobremesasMaisVendidas();

    @Query(value = "SELECT c.nome_prato AS nome_prato, SUM(ivd.quantidade) AS quantidade\n" +
            "FROM tb_item_venda_diaria ivd\n" +
            "JOIN tb_cardapio c ON ivd.cod_prato = c.cod_prato\n" +
            "WHERE c.categoria = 'bebida'\n" +
            "GROUP BY c.nome_prato\n" +
            "ORDER BY quantidade DESC\n" +
            "FETCH FIRST 3 ROWS ONLY", nativeQuery = true)
    List<Object[]> bebidasMaisVendidas();


}