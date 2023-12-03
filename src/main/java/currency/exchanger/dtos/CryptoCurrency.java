package currency.exchanger.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public record CryptoCurrency(
        @JsonProperty("id")
        int id,
        @JsonProperty("name")
        String name,
        @JsonProperty("symbol")
        String symbol,
        @JsonProperty("slug")
        String slug,
        @JsonProperty("num_market_pairs")
        int numMarketPairs,
        @JsonProperty("date_added")
        String dataAdded,
        @JsonProperty("tags")
        List<String> tags,
        @JsonProperty("max_supply")
        BigInteger maxSupply,
        @JsonProperty("circulating_supply")
        BigInteger circulatingSupply,
        @JsonProperty("total_supply")
        BigInteger totalSupply,
        @JsonProperty("infinite_supply")
        boolean infiniteSupply,
        @JsonProperty("platform")
        Platform platform,
        @JsonProperty("cmc_rank")
        int cmcRank,
        @JsonProperty("self_reported_circulating_supply")
        String selfReportedCirculatingSupply,
        @JsonProperty("self_reported_market_cap")
        String selfReportedMarketCap,
        @JsonProperty("tvl_ratio")
        String tvlRatio,
        @JsonProperty("last_updated")
        String lastUpdated,
        @JsonProperty("quote")
        Map<String, Conversion> quote


) {
}
