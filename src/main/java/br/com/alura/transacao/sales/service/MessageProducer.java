package br.com.alura.transacao.sales.service;

import br.com.alura.transacao.sales.model.dto.AlbumDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface MessageProducer {

    public void enviarMensagemCompraAlbum(List<AlbumDTO> albumDTOList) throws JsonProcessingException;
}
