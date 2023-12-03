package currency.exchanger.telegram.bot;

import currency.exchanger.telegram.bot.utils.UserState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.objects.*;

import java.util.HashMap;

import static org.telegram.abilitybots.api.util.AbilityUtils.*;

@Component
@Slf4j
public class CryptoCurrencyBot extends AbilityBot {
    public static final String START_DESCRIPTION = "Начинаю работать!";
    private final UserState userState;

    @Autowired
    private ResponseHandler responseHandler;

    public CryptoCurrencyBot(@Value("${bot.token}") String botToken, DBContext dbContext, UserState userState) {
        super(botToken, "exchanger", dbContext);
        this.userState = userState;
    }

    public Ability startBot() {
        return Ability
                .builder()
                .name("start")
                .info(START_DESCRIPTION)
                .locality(Locality.USER)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> {
                    log.info("Начало работы телеграм бота, для пользователя {}", ctx.chatId());
                    userState.setNextAction("start");
                    userState.setChatId(ctx.chatId());
                    userState.setUserResponsesContainer(new HashMap<>());
                    responseHandler.replyToStart(userState, this.silent());
                })
                .build();
    }

    public Reply replyToButtons() {
        return Reply.of(((baseAbilityBot, update) -> {
            log.info("Перехват сообщения пользователя {}", update.getMessage().getText());
            userState.setUserResponse(update.getMessage().getText());
            responseHandler.replyToButtons(userState, this.silent());
        }), Flag.TEXT, upd -> responseHandler.userIsActive(getChatId(upd)));
    }

    @Override
    public long creatorId() {
        return 1L;
    }
}
