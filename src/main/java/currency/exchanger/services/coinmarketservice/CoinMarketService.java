package currency.exchanger.services.coinmarketservice;

import currency.exchanger.dtos.CryptoCurrency;
import currency.exchanger.dtos.CryptoCurrencyListingsLatest;

import java.util.List;

/**
 * Сервис обработки coinmarketcap
 */
public interface CoinMarketService {


    CryptoCurrencyListingsLatest getAllCurrencies(String quota);

    CryptoCurrency getOneCurrency(String currency, String quota);

    List<CryptoCurrency> getSomeCurrencies(String...symbols);

    String getOneCurrencyPrice(String currency, String quota);

}
