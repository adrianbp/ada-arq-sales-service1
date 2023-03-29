package br.com.alura.transacao.sales.service;

import br.com.alura.transacao.sales.model.dto.AlbumDTO;
import br.com.alura.transacao.sales.model.dto.FigurinhaDTO;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface AlbumService {


    public ResponseEntity<?> transfereFigurinha(AlbumDTO albumOrigem , AlbumDTO  albumDestino, List<FigurinhaDTO> figurinha);
}
