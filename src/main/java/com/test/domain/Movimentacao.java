package com.test.domain;

import com.test.domain.enums.TipoOperacao;

import java.math.BigDecimal;

public record Movimentacao (
        BigDecimal valor,
        TipoOperacao tipoOperacao,
        Long idOrigem,
        Long idDestino
){
}
