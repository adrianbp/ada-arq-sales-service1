package br.com.alura.transacao.sales.service.impl;

import br.com.alura.transacao.sales.model.dto.*;
import br.com.alura.transacao.sales.model.entity.Sale;
import br.com.alura.transacao.sales.model.mapper.SaleMapper;
import br.com.alura.transacao.sales.repository.SalesRepository;
import br.com.alura.transacao.sales.service.AlbumService;
import br.com.alura.transacao.sales.service.TransferenciaService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private SalesRepository salesRepository;
    private AlbumService albumService;

    private SaleMapper saleMapper;


    public TransferenciaServiceImpl(SalesRepository salesRepository, AlbumService albumService, SaleMapper saleMapper){

        this.salesRepository = salesRepository;
        this.albumService  = albumService;
        this.saleMapper = saleMapper;
    }


    @Override
    @Transactional
    public SaleDTO transfereFigurinha(VendaRequestDTO vendaRequestDTO) {

        //Sale.Builder
       Sale sale =  Sale.builder()
                .albumOrigem(vendaRequestDTO.getAlbumOrigem().getIdentificador())
                .albumDestino(vendaRequestDTO.getAlbumDestino().getIdentificador())
                .quantidade(vendaRequestDTO.getFigurinhaDTOList().stream().map(x -> x.getQuantidade()).reduce(BigDecimal.ZERO,BigDecimal::add))
                .valorTotal(vendaRequestDTO.getFigurinhaDTOList().stream().map(x -> x.getQuantidade().multiply(x.getPreco())).reduce(BigDecimal.ZERO,BigDecimal::add))
                .formaPagamento(vendaRequestDTO.getPagamentoDTO().getFormaPagamento())
                .detalhesPagamento(vendaRequestDTO.getPagamentoDTO().getDetalhePagamento())
                .dataHoraTransacao(LocalDateTime.now(Clock.systemUTC())).build();


        salesRepository.save(sale);

        return saleMapper.parseDTO(sale);
    }
}
