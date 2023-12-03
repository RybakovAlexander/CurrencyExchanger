package currency.exchanger.services.coinmarketservice.impl;

import currency.exchanger.dtos.CryptoCurrency;
import currency.exchanger.dtos.CryptoCurrencyListingsLatest;
import currency.exchanger.integrations.CoinMarketIntegration;
import currency.exchanger.integrations.impl.CoinMarketIntegrationImpl;
import currency.exchanger.services.coinmarketservice.CoinMarketService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinMarketServiceImpl implements CoinMarketService {
    private final CoinMarketIntegration coinMarket;
    @Override
    public CryptoCurrencyListingsLatest getAllCurrencies(String quota) {
        return coinMarket.getAllCurrencies(quota);
    }

    @Override
    public CryptoCurrency getOneCurrency(String currency, String quota) {
        return coinMarket
                .getAllCurrencies(quota)
                .data()
                .stream()
                .filter(cryptoCurrency -> cryptoCurrency
                    .symbol()
                    .equalsIgnoreCase(currency))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CryptoCurrency> getSomeCurrencies(String...symbols) {

        throw new NotImplementedException("Метод не реализован");
    }

    @Override
    public String getOneCurrencyPrice(String currency, String quota) {
        return getOneCurrency(currency, quota)
                .quote()
                .get(quota)
                .price()
                .toString();
    }
}
