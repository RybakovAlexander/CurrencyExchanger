package currency.exchanger.integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import currency.exchanger.dtos.CryptoCurrencyListingsLatest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
public class DeserializationTest {


    @Test
    void deserialize() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResource("mock.files/ListingLatest.json"), StandardCharsets.UTF_8);


        ObjectMapper objectMapper = new ObjectMapper();
        CryptoCurrencyListingsLatest currencyListingsLatest = objectMapper.readValue(result, CryptoCurrencyListingsLatest.class);
        log.info(currencyListingsLatest.toString());

    }
}
