package currency.exchanger.services.kafkaproducerservice.impl;

import currency.exchanger.dtos.Conversion;
import currency.exchanger.producer.KafkaCryptoCurrencyConversionProducer;
import currency.exchanger.services.kafkaproducerservice.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaCryptoCurrencyConversionProducer producer;
    @Override
    public void sendMessage(Conversion msg) {
        producer.sendMessage(msg);
    }
}
