package br.com.alura.transacao.sales.model.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class AlbumCompraDTO {

    private String identificador;

    private BigDecimal valor;
}
