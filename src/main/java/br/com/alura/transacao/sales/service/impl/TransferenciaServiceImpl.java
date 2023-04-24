package br.com.alura.transacao.sales.service.impl;

import br.com.alura.transacao.sales.model.dto.*;
import br.com.alura.transacao.sales.model.entity.Banca;
import br.com.alura.transacao.sales.model.mapper.SaleMapper;
import br.com.alura.transacao.sales.repository.SalesRepository;
import br.com.alura.transacao.sales.service.AlbumService;
import br.com.alura.transacao.sales.service.MessageProducer;
import br.com.alura.transacao.sales.service.TransferenciaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    private SalesRepository salesRepository;
    private AlbumService albumService;

    private SaleMapper saleMapper;

    private MessageProducer messageProducer;


    public TransferenciaServiceImpl(SalesRepository salesRepository, AlbumService albumService, SaleMapper saleMapper, MessageProducer messageProducer ){

        this.salesRepository = salesRepository;
        this.albumService  = albumService;
        this.saleMapper = saleMapper;
        this.messageProducer = messageProducer;
    }


    @Override
    @Transactional
    public SaleDTO transfereFigurinha(VendaRequestDTO vendaRequestDTO) {

        //Sale.Builder
       Banca banca =  Banca.builder()
                .albumOrigem(vendaRequestDTO.getAlbumOrigem().getIdentificador())
                .albumDestino(vendaRequestDTO.getAlbumDestino().getIdentificador())
                .quantidade(vendaRequestDTO.getFigurinhaDTOList().stream().map(x -> x.getQuantidade()).reduce(BigDecimal.ZERO,BigDecimal::add))
                .valorTotal(vendaRequestDTO.getFigurinhaDTOList().stream().map(x -> x.getQuantidade().multiply(x.getPreco())).reduce(BigDecimal.ZERO,BigDecimal::add))
                .formaPagamento(vendaRequestDTO.getPagamentoDTO().getFormaPagamento())
                .detalhesPagamento(vendaRequestDTO.getPagamentoDTO().getDetalhePagamento())
                .dataHoraTransacao(LocalDateTime.now(Clock.systemUTC())).build();


        salesRepository.save(banca);

        return saleMapper.parseDTO(banca);
    }

    @Override
    @Transactional
    public Object comprarAlbum(ComprarAlbumRequestDTO albumDTO) throws JsonProcessingException {

        Iterator  albumIterator =  albumDTO.getAlbumCompraDTO().iterator();


        List<AlbumDTO> albumDTOList = new ArrayList<>();

        while(albumIterator.hasNext()) {
            AlbumCompraDTO albumCompraDTO = (AlbumCompraDTO) albumIterator.next();

            AlbumDTO albumDTO1 = new AlbumDTO();

            albumDTO1.setIdentificador(albumCompraDTO.getIdentificador());


            Banca banca =  Banca.builder()
                    .albumOrigem("1")
                    .albumDestino(albumCompraDTO.getIdentificador())
                    .quantidade(new BigDecimal(1))
                    .valorTotal(albumCompraDTO.getValor())
                    .formaPagamento(albumDTO.getPagamentoDTO().getFormaPagamento())
                    .detalhesPagamento(albumDTO.getPagamentoDTO().getDetalhePagamento())
                    .dataHoraTransacao(LocalDateTime.now(Clock.systemUTC())).build();

            salesRepository.save(banca);

            albumDTOList.add(albumDTO1);

            albumDTO1 = null;

        }

        messageProducer.enviarMensagemCompraAlbum(albumDTOList);

        albumDTOList = null;





        return new ResponseEntity<>((HttpStatus.OK));



    }
}
