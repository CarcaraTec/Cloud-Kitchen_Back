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

    @Query(value = "SELECT nome_prato, quantidade " +
            "FROM (" +
            "    SELECT c.nome_prato AS nome_prato, SUM(ivd.quantidade) AS quantidade, " +
            "           ROW_NUMBER() OVER (ORDER BY SUM(ivd.quantidade) ASC) as row_num " +
            "    FROM tb_item_venda_diaria ivd " +
            "    JOIN tb_cardapio c ON ivd.cod_prato = c.cod_prato " +
            "    WHERE c.categoria = 'prato principal' " +
            "    GROUP BY c.nome_prato " +
            ") " +
            "WHERE row_num <= 3", nativeQuery = true)
    List<Object[]> pratosPrincipaisMenosVendidos();

    @Query(value = "SELECT nome_prato, quantidade " +
            "FROM (" +
            "    SELECT c.nome_prato AS nome_prato, SUM(ivd.quantidade) AS quantidade, " +
            "           ROW_NUMBER() OVER (ORDER BY SUM(ivd.quantidade) DESC) as row_num " +
            "    FROM tb_item_venda_diaria ivd " +
            "    JOIN tb_cardapio c ON ivd.cod_prato = c.cod_prato " +
            "    WHERE c.categoria = 'sobremesa' " +
            "    GROUP BY c.nome_prato " +
            ") " +
            "WHERE row_num > (SELECT COUNT(*) FROM tb_cardapio WHERE categoria = 'sobremesa') - 3", nativeQuery = true)
    List<Object[]> sobremesasMenosVendidas();

    @Query(value = "SELECT nome_prato, quantidade " +
            "FROM (" +
            "    SELECT c.nome_prato AS nome_prato, SUM(ivd.quantidade) AS quantidade, " +
            "           ROW_NUMBER() OVER (ORDER BY SUM(ivd.quantidade) DESC) as row_num " +
            "    FROM tb_item_venda_diaria ivd " +
            "    JOIN tb_cardapio c ON ivd.cod_prato = c.cod_prato " +
            "    WHERE c.categoria = 'bebida' " +
            "    GROUP BY c.nome_prato " +
            ") " +
            "WHERE row_num > (SELECT COUNT(*) FROM tb_cardapio WHERE categoria = 'bebida') - 3", nativeQuery = true)
    List<Object[]> bebidasMenosVendidas();

}
