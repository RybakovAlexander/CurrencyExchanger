package currency.exchanger.telegram.bot.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@Component
public class UserState implements Serializable {

    private String nextAction;
    private Long chatId;
    private String userResponse;
    private Map<String, String> userResponsesContainer;



}
