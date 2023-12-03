package currency.exchanger.integrations;

import currency.exchanger.dtos.CryptoCurrencyListingsLatest;

public interface CoinMarketIntegration {
    CryptoCurrencyListingsLatest  getAllCurrencies(String quota);
}
