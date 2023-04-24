package br.com.alura.transacao.sales.model.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class ComprarAlbumRequestDTO {

    private List<AlbumCompraDTO> albumCompraDTO;

    private PagamentoDTO pagamentoDTO;


}
