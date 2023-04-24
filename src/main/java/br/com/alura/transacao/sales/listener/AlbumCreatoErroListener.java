package br.com.alura.transacao.sales.listener;

import br.com.alura.transacao.sales.model.dto.AlbumDTO;
import br.com.alura.transacao.sales.repository.SalesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumCreatoErroListener {

    private SalesRepository salesRepository;

    public AlbumCreatoErroListener(SalesRepository salesRepository) {

        this.salesRepository = salesRepository;

    }

    @KafkaListener(topics = "ALBUM-CREATION-ERROR", groupId = "group_id")
    public void listenGroupFoo(String message) throws JsonProcessingException {

        System.out.println("Received Message in group foo: " + message);

        ObjectMapper mapper = new ObjectMapper();

        CollectionType listType =
                mapper.getTypeFactory().constructCollectionType(ArrayList.class, AlbumDTO.class);

        List<AlbumDTO> albumDTOList = mapper.readValue(message, listType);

        System.out.println("Retorno 1 " + albumDTOList.get(0).getIdentificador());
        System.out.println("Retorno 2 " + albumDTOList.get(1).getIdentificador());


    }
}
