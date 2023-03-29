package br.com.alura.transacao.sales.model.dto;

import lombok.*;

import java.util.List;


public class VendaRequestDTO {

    private AlbumDTO albumOrigem;
    private AlbumDTO albumDestino;

    private List<FigurinhaDTO> figurinhaDTOList;
    private PagamentoDTO pagamentoDTO;

    public AlbumDTO getAlbumOrigem() {
        return albumOrigem;
    }

    public AlbumDTO getAlbumDestino() {
        return albumDestino;
    }

    public List<FigurinhaDTO> getFigurinhaDTOList() {
        return figurinhaDTOList;
    }

    public PagamentoDTO getPagamentoDTO() {
        return pagamentoDTO;
    }


}
