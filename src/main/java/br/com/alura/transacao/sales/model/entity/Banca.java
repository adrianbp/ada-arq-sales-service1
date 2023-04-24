package br.com.alura.transacao.sales.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="sale")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Banca {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="albumOrigem")
    private String albumOrigem;
    @Column(name="albumDestino")
    private String albumDestino;
    @Column(name="quantidade")
    private BigDecimal quantidade;
    @Column(name="valorTotal")
    private BigDecimal valorTotal;
    @Column(name="formaPagamento")
    private String formaPagamento;
    @Column(name = "detalhePagamento")
    private String detalhesPagamento;
    @Column(name="dataHoraTransacao")
    private LocalDateTime dataHoraTransacao;
    




}
