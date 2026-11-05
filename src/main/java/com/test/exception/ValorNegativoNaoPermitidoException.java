package com.test.exception;

public class ValorNegativoNaoPermitidoException extends  RuntimeException {
    public ValorNegativoNaoPermitidoException(String mensagem) {
        super(mensagem);
    }
}
