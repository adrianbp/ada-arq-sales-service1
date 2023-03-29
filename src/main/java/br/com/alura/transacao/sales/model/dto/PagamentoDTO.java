package br.com.alura.transacao.sales.model.dto;

import lombok.Data;


public class PagamentoDTO {

    private String formaPagamento;
    private String detalhePagamento;

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public String getDetalhePagamento() {
        return detalhePagamento;
    }
}
