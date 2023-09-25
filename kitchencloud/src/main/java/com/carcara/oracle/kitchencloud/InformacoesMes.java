package com.carcara.oracle.kitchencloud;

import java.time.LocalDate;
import java.time.YearMonth;

public class InformacoesMes {
    private int numeroDoDia;
    private LocalDate primeiroDiaDoMes;
    private LocalDate ultimoDiaDoMes;

    public InformacoesMes() {
        LocalDate dataAtual = LocalDate.now().plusDays(1);
        YearMonth mesAtual = YearMonth.from(dataAtual);

        this.numeroDoDia = (dataAtual.getDayOfWeek().getValue() % 7) + 1;
        this.primeiroDiaDoMes = mesAtual.atDay(1);
        this.ultimoDiaDoMes = mesAtual.atEndOfMonth();
    }

    public int getNumeroDoDia() {
        return numeroDoDia;
    }

    public LocalDate getPrimeiroDiaDoMes() {
        return primeiroDiaDoMes;
    }

    public LocalDate getUltimoDiaDoMes() {
        return ultimoDiaDoMes;
    }

    public static void main(String[] args) {
        InformacoesMes informacoes = new InformacoesMes();

        System.out.println("Número do dia: " + informacoes.getNumeroDoDia());
        System.out.println("Primeiro dia do mês: " + informacoes.getPrimeiroDiaDoMes());
        System.out.println("Último dia do mês: " + informacoes.getUltimoDiaDoMes());
    }
}
