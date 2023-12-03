package currency.exchanger.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.security.Timestamp;
import java.text.SimpleDateFormat;

public record Status(
        @JsonProperty("timestamp")
        String timestamp,
        @JsonProperty("error_code")
        int errorCode,
        @JsonProperty("error_message")
        String errorMessage,
        @JsonProperty("elapsed")
        int elapsed,
        @JsonProperty("credit_count")
        int creditCount,
        @JsonProperty("notice")
        String notice,
        @JsonProperty("total_count")
        int totalCount
) {
}
