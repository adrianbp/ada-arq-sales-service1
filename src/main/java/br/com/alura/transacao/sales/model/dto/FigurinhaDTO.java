package br.com.alura.transacao.sales.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


public class FigurinhaDTO {

    private String imagem;
    private String descricao;
    private String   raridade;
    private BigDecimal quantidade;
    private BigDecimal preco;


    public String getImagem() {
        return imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRaridade() {
        return raridade;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
