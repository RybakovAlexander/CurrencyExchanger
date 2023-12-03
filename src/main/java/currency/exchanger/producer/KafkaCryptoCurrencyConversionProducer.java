package currency.exchanger.producer;

import currency.exchanger.dtos.Conversion;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaCryptoCurrencyConversionProducer {

    private final KafkaTemplate<String, Conversion> kafkaTemplate;

    public void sendMessage(Conversion conversion){
        Message<Conversion> message = MessageBuilder
                .withPayload(conversion)
                        .setHeader(KafkaHeaders.TOPIC, "conversion")
                                .build();
        kafkaTemplate.send(message);
    }
}
