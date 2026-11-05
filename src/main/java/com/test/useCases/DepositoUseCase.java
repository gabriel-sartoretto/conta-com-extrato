package com.test.useCases;

import com.test.domain.Conta;

import java.math.BigDecimal;

public class DepositoUseCase {

    public void depositar(Conta conta, BigDecimal valor) {
        conta.depositar(valor);
    }
}
