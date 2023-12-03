package currency.exchanger.controller;


import currency.exchanger.dtos.Conversion;
import currency.exchanger.dtos.CryptoCurrencyListingsLatest;
import currency.exchanger.producer.KafkaCryptoCurrencyConversionProducer;
import currency.exchanger.services.coinmarketservice.CoinMarketService;
import currency.exchanger.services.kafkaproducerservice.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/exchanger")
@RequiredArgsConstructor
public class RestController {

    private final CoinMarketService coinMarketService;
    private final KafkaProducerService kafkaProducerService;

    @GetMapping("/getAll")
    public ResponseEntity<CryptoCurrencyListingsLatest> getAll(@RequestParam String quota){
        return ResponseEntity.ok(coinMarketService.getAllCurrencies(quota));
    }


    @PostMapping("/sendToKafkaCrypto")
    public ResponseEntity<String> sendMessage(
            @RequestBody Conversion body){
        kafkaProducerService.sendMessage(body);
        return ResponseEntity.ok("Messege queued as json Crypto");
    }
}

