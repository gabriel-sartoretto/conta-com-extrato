package com.test.useCases;

import com.test.domain.Conta;

import java.math.BigDecimal;

public class SaqueUseCase {

    public void sacar(Conta conta, BigDecimal valor) {
        conta.sacar(valor);
    }
}
