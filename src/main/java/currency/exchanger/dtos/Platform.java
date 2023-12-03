package currency.exchanger.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Platform(
        @JsonProperty("id")
        int id,
        @JsonProperty("name")
        String name,
        @JsonProperty("symbol")
        String symbol,
        @JsonProperty("slug")
        String slug,
        @JsonProperty("token_address")
        String token_address

) {
}
