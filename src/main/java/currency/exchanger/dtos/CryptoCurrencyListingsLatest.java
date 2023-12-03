package currency.exchanger.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public record CryptoCurrencyListingsLatest(
        @JsonProperty("status")
        Status status,
        @JsonProperty("data")
        List<CryptoCurrency> data
) {
}
