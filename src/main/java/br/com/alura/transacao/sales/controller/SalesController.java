package br.com.alura.transacao.sales.controller;

import br.com.alura.transacao.sales.model.dto.*;
import br.com.alura.transacao.sales.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private TransferenciaService transferenciaService;


    public SalesController(TransferenciaService transferenciaService) {

        this.transferenciaService = transferenciaService;
    }


    @PostMapping
    public ResponseEntity<SaleDTO> efetivarVenda(@RequestBody VendaRequestDTO vendaRequestDTO) {
        try {


            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(transferenciaService.transfereFigurinha(vendaRequestDTO));

        }catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
