package br.com.alura.transacao.sales.service;

import br.com.alura.transacao.sales.model.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface TransferenciaService {

    public SaleDTO transfereFigurinha(VendaRequestDTO vendaRequestDTO);

    Object comprarAlbum(ComprarAlbumRequestDTO albumDTO) throws JsonProcessingException;
}
