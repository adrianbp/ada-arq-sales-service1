package br.com.alura.transacao.sales.service.impl;

import br.com.alura.transacao.sales.model.dto.AlbumDTO;
import br.com.alura.transacao.sales.model.dto.FigurinhaDTO;
import br.com.alura.transacao.sales.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Override
    public ResponseEntity<?> transfereFigurinha(AlbumDTO albumOrigem, AlbumDTO albumDestino, List<FigurinhaDTO> figurinha) {

        return null;
    }
}
