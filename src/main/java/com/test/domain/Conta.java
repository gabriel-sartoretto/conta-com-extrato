package com.test.domain;

import com.test.domain.enums.TipoOperacao;
import com.test.exception.SaldoInsuficienteException;
import com.test.exception.ValorNegativoNaoPermitidoException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conta {

    private Long id;
    private BigDecimal saldo;
    private BigDecimal limite;

    private final List<Movimentacao> movimentacoes = new ArrayList<>();

    public Conta(Long id, BigDecimal saldo, BigDecimal limite) {
        this.id = id;
        this.saldo = saldo;
        this.limite = limite;
    }

    public void sacar(BigDecimal valor) {
        validarValor(valor);
        if (this.saldo.subtract(valor).compareTo(this.limite.negate()) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        this.saldo = debitar(valor);
        movimentacoes.add(new Movimentacao(valor, TipoOperacao.SAQUE, this.id, null));
    }

    private static void validarValor(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorNegativoNaoPermitidoException("Não permitido");
        }
    }

    public void depositar(BigDecimal valor) {
        validarValor(valor);
        this.saldo = this.saldo.add(valor);
        movimentacoes.add(new Movimentacao(valor, TipoOperacao.DEPOSITO, this.id, null));
    }

    public List<Movimentacao> getMovimentacoes() {
        return Collections.unmodifiableList(movimentacoes);
    }

    public void aplicarTarifa(BigDecimal valor) {
        this.saldo = debitar(valor);
    }

    private BigDecimal debitar(BigDecimal valor) {
        return this.saldo.subtract(valor);
    }
}
