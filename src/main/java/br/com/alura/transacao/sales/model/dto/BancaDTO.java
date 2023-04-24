package br.com.alura.transacao.sales.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BancaDTO {

    private Long id;
    private String albumOrigem;
    private String albumDestino;
    private Long quantidade;
    private BigDecimal valorTotal;
    private String formaPagamento;
    private String detalhesPagamento;
    private LocalDateTime dataHoraTransacao;
}
