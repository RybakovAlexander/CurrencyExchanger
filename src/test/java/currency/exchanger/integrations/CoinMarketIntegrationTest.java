package currency.exchanger.integrations;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import currency.exchanger.integrations.impl.CoinMarketIntegrationImpl;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WireMockTest(httpPort = 7071)
@TestPropertySource("classpath:test.properties")
class CoinMarketIntegrationTest {

    @Autowired
    CoinMarketIntegrationImpl coinMarketIntegration;

    @Test
    public void getAllCurrencies_shouldReturnCryptoCurrencyListingLatestDTO() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        stubFor(get(
                urlEqualTo("/v1/cryptocurrency/listings/latest?convert=USD"))
                .willReturn(aResponse()
                        .withBody(
                                IOUtils.toString(classLoader.getResource("mock.files/ListingLatest.json"), StandardCharsets.UTF_8))));




    }

}