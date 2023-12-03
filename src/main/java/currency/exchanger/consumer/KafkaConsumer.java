package currency.exchanger.consumer;

import currency.exchanger.dtos.Conversion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static java.lang.String.*;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "conversion", groupId = "myGroup")
    public void consumeMessage(@Payload Conversion msg){
        log.info(format("Consuming from exchanger topic::: %s", msg));

    }
}
