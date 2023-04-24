package br.com.alura.transacao.sales.controller;

import br.com.alura.transacao.sales.model.dto.AlbumDTO;
import br.com.alura.transacao.sales.model.dto.ComprarAlbumRequestDTO;
import br.com.alura.transacao.sales.model.dto.SaleDTO;
import br.com.alura.transacao.sales.model.dto.VendaRequestDTO;
import br.com.alura.transacao.sales.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banca")
public class BancaController {

    private TransferenciaService transferenciaService;


    public BancaController(TransferenciaService transferenciaService) {

        this.transferenciaService = transferenciaService;
    }


    @PostMapping
    public ResponseEntity<Object> comprarAlbum(@RequestBody ComprarAlbumRequestDTO comprarAlbumRequestDTO) {
        try {



            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(transferenciaService.comprarAlbum(comprarAlbumRequestDTO));

        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
