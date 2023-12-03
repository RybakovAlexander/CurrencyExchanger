package currency.exchanger.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record Conversion(
        @JsonProperty("price")
        BigDecimal price,
        @JsonProperty("volume_24h")
        BigDecimal volume24h,
        @JsonProperty("volume_change_24h")
        BigDecimal volumeChange24h,
        @JsonProperty("percent_change_1h")
        BigDecimal percentChange1h,
        @JsonProperty("percent_change_24h")
        BigDecimal percentChange24h,
        @JsonProperty("percent_change_7d")
        BigDecimal percentChange7d,
        @JsonProperty("percent_change_30d")
        BigDecimal percentChange30d,
        @JsonProperty("percent_change_60d")
        BigDecimal percentChange60d,
        @JsonProperty("percent_change_90d")
        BigDecimal percentChange90d,
        @JsonProperty("market_cap")
        BigDecimal marketCap,
        @JsonProperty("market_cap_dominance")
        BigDecimal marketCapDominance,
        @JsonProperty("fully_diluted_market_cap")
        BigDecimal fullyDilutedMarketCap,
        @JsonProperty("tvl")
        String tlv,
        @JsonProperty("last_updated")
        String lastUpdated
) {
}
