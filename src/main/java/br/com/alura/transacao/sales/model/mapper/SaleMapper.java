package br.com.alura.transacao.sales.model.mapper;

import br.com.alura.transacao.sales.model.dto.SaleDTO;
import br.com.alura.transacao.sales.model.entity.Sale;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleMapper {


    List<SaleDTO> parseListDTO(List<Sale> sales);
    List<Sale> parseListEntity(List<SaleDTO> saleDTOList);
    SaleDTO parseDTO(Sale sale);
    Sale parseEntity(SaleDTO saleDTO);

}
