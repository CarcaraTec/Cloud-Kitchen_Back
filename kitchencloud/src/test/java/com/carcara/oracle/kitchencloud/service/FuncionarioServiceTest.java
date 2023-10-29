package com.carcara.oracle.kitchencloud.service;

import com.carcara.oracle.kitchencloud.model.Comanda;
import com.carcara.oracle.kitchencloud.model.Funcionario;
import com.carcara.oracle.kitchencloud.repository.ComandaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FuncionarioServiceTest {


    @Mock
    private ComandaRepository comandaRepository;
    @InjectMocks
    private FuncionarioService funcionarioService;

    Comanda comanda1 = new Comanda();
    Comanda comanda2 = new Comanda();
    Comanda comanda3 = new Comanda();

    Funcionario funcionario1 = new Funcionario();
    Funcionario funcionario2 = new Funcionario();

    @BeforeEach
    public void setUp() {
        funcionario1.setCodFuncionario(1L);
        funcionario1.setNomeFuncionario("funcionario1");

        funcionario2.setCodFuncionario(2L);
        funcionario2.setNomeFuncionario("funcionario2");
    }

    @Test
    public void calculoRendimentoData1AndData2NullTest() {
        LocalDateTime data1 = LocalDateTime.now();
        LocalDateTime data2 = LocalDateTime.now().minusDays(30);

        comanda1.setFuncionario(funcionario1);
        comanda2.setFuncionario(funcionario2);

        List<Comanda> comandas = new ArrayList<>();
        comandas.add(comanda1);
        comandas.add(comanda2);

        when(comandaRepository.findByHorarioAberturaBetween(data1, data2)).thenReturn(comandas);

        Map<String, Double> resultadoEsperado = new HashMap<>();
        resultadoEsperado.put(funcionario1.getNomeFuncionario(), 50D);
        resultadoEsperado.put(funcionario2.getNomeFuncionario(), 50D);

        Map<String, Double> result = funcionarioService.calculoRendimento(data1, data2);

        assertEquals(comandas.size(), result.size());
        assertEquals(resultadoEsperado, result);
    }

    @Test
    public void calculoRendimentoData2NullTest(){
        LocalDateTime data1 = LocalDateTime.of(2023, 10, 29, 15, 30);
        LocalDateTime data2 = null;

        comanda1.setHorarioAbertura(Timestamp.valueOf(data1));
        comanda1.setFuncionario(funcionario1);

        comanda2.setHorarioAbertura(Timestamp.valueOf(LocalDateTime.now().withNano(0)));
        comanda2.setFuncionario(funcionario2);

        List<Comanda> comandas = new ArrayList<>();
        comandas.add(comanda1);
        comandas.add(comanda2);

        when(comandaRepository.findByHorarioAberturaBetween(data1, data1)).thenReturn(Collections.singletonList(comanda1));

        Map<String, Double> resultadoEsperado = new HashMap<>();
        resultadoEsperado.put(funcionario1.getNomeFuncionario(), 100D);

        Map<String, Double> result = funcionarioService.calculoRendimento(data1, data2);

        assertEquals(resultadoEsperado.size(), result.size());
        assertEquals(resultadoEsperado, result);
    }

    @Test
    public void calculoRendimentoData1AndData2NotNullTest(){
        LocalDateTime data1 = LocalDateTime.of(2023, 10, 29, 15, 30);
        LocalDateTime data2 = LocalDateTime.of(2023, 11, 29, 15, 30);

        comanda1.setHorarioAbertura(Timestamp.valueOf(data1));
        comanda1.setFuncionario(funcionario1);

        comanda2.setHorarioAbertura(Timestamp.valueOf(data2));
        comanda2.setFuncionario(funcionario2);

        List<Comanda> comandas = new ArrayList<>();
        comandas.add(comanda1);
        comandas.add(comanda2);

        when(comandaRepository.findByHorarioAberturaBetween(data1, data2)).thenReturn(comandas);

        Map<String, Double> resultadoEsperado = new HashMap<>();
        resultadoEsperado.put(funcionario1.getNomeFuncionario(), 50D);
        resultadoEsperado.put(funcionario2.getNomeFuncionario(), 50D);

        Map<String, Double> result = funcionarioService.calculoRendimento(data1, data2);

        assertEquals(resultadoEsperado.size(), result.size());
        assertEquals(resultadoEsperado, result);
    }
}


