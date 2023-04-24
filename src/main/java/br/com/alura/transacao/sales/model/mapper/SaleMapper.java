package br.com.alura.transacao.sales.model.mapper;

import br.com.alura.transacao.sales.model.dto.SaleDTO;
import br.com.alura.transacao.sales.model.entity.Banca;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {


    List<SaleDTO> parseListDTO(List<Banca> sales);
    List<Banca> parseListEntity(List<SaleDTO> saleDTOList);
    SaleDTO parseDTO(Banca banca);
    Banca parseEntity(SaleDTO saleDTO);

}
