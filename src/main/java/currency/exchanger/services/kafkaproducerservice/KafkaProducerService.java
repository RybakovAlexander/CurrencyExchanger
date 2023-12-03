package currency.exchanger.services.kafkaproducerservice;

import currency.exchanger.dtos.Conversion;

public interface KafkaProducerService {
   void sendMessage(Conversion msg);
}
