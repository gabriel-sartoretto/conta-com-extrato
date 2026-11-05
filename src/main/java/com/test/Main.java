package com.test;

import com.test.domain.Conta;
import com.test.out.response.Extrato;
import com.test.useCases.DepositoUseCase;
import com.test.useCases.SaqueUseCase;
import com.test.useCases.TransferenciaUseCase;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Conta conta = new Conta(1L, new BigDecimal("100.00"), BigDecimal.ZERO);
        Conta conta2 = new Conta(2L, new BigDecimal("400"), new BigDecimal("10.00"));
        Conta externa = new Conta(3L, new BigDecimal("1"), BigDecimal.ZERO);

        SaqueUseCase saqueUseCase = new SaqueUseCase();
        saqueUseCase.sacar(conta, new BigDecimal("100.00"));

        DepositoUseCase depositoUseCase = new DepositoUseCase();
        depositoUseCase.depositar(externa, new BigDecimal("5.00"));

        TransferenciaUseCase transferenciaUseCase = new TransferenciaUseCase();
        transferenciaUseCase.transferir(conta2, conta, new BigDecimal("50.00"));

        System.out.println(new Extrato(conta.getMovimentacoes()));
    }
}