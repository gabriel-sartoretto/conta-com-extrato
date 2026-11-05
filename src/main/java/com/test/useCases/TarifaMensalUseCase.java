package com.test.useCases;

import com.test.domain.Conta;

import java.math.BigDecimal;

public class TarifaMensalUseCase {

    public void aplicarTarifa(Conta conta, BigDecimal valor) {
        conta.aplicarTarifa(valor);
    }
}
