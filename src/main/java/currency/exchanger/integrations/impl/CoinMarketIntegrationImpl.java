package currency.exchanger.integrations.impl;


import currency.exchanger.dtos.CryptoCurrencyListingsLatest;
import currency.exchanger.integrations.CoinMarketIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class CoinMarketIntegrationImpl implements CoinMarketIntegration {

    private final WebClient webClient;

    @Override
    public CryptoCurrencyListingsLatest  getAllCurrencies(String quota){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("v1/cryptocurrency/listings/latest")
                        .queryParam("convert", quota)
                        .build())
                .retrieve()
                .bodyToMono(CryptoCurrencyListingsLatest.class)
                .cache(Duration.ofSeconds(10))
                .block();

    }



}
