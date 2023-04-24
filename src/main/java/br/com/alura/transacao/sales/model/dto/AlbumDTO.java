package br.com.alura.transacao.sales.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter

public class AlbumDTO {



    private String identificador;
    @JsonProperty
    public String getIdentificador() {
        return identificador;
    }

}
