package com.test.out.response;

import com.test.domain.Movimentacao;

import java.util.List;

public record Extrato(
        List<Movimentacao> movimentacoes
) {
}
