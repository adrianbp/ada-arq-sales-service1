package br.com.alura.transacao.sales.service.impl;

import br.com.alura.transacao.sales.model.dto.AlbumDTO;
import br.com.alura.transacao.sales.service.MessageProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class MessageProducerImpl implements MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void enviarMensagemCompraAlbum(List<AlbumDTO> albumDTOList) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        String jsonInString = mapper.writeValueAsString(albumDTOList);

        sendMessage(jsonInString);



    }


    private void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("SALE-APPROVED", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }
}
