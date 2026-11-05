package com.test.useCases;

import com.test.domain.Conta;

import java.math.BigDecimal;

public class TransferenciaUseCase {

    public void transferir(Conta origem, Conta destino, BigDecimal valor) {
        // saca antes de depositar para evitar erro e depositar ter que reverter
        origem.sacar(valor);
        destino.depositar(valor);
    }
}
