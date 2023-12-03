package currency.exchanger.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class RestControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @SneakyThrows
    void getAllCurrencies_ReturnResponseWith200ok(){
        this.mockMvc.perform(get("/exchanger/getall?quota=USD"))
                .andDo(print())
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.data[0].quote").hasJsonPath()
                );
    }

}