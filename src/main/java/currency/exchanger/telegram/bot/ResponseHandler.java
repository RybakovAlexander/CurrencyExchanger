package currency.exchanger.telegram.bot;

import currency.exchanger.telegram.bot.actions.ActionManager;
import currency.exchanger.telegram.bot.utils.UserState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.db.DBContext;
import org.telegram.abilitybots.api.sender.SilentSender;

import java.util.Map;

import static currency.exchanger.telegram.bot.utils.Constants.*;


@Component
@Slf4j
public class ResponseHandler {

    private static final String CHAT_STATES = "chatStates";
    private final ActionManager actionManager;
    private final Map<Long, UserState> dbMap;
    private final DBContext context;
    @Autowired
    public ResponseHandler(ActionManager actionManager , DBContext dbContext) {
        this.actionManager = actionManager;
        this.context = dbContext;
        this.dbMap = context.getMap(CHAT_STATES);
    }

    public void replyToStart(UserState userState, SilentSender sender) {
        log.info(context.summary());
        actionManager.doAction(userState, sender);
        userState.setNextAction(CHOOSE_CURRENCY);
        dbMap.put(userState.getChatId(), userState);
    }

    public boolean userIsActive(Long chatId) {
        return dbMap.containsKey(chatId);
    }
    public void replyToButtons(UserState userState, SilentSender sender) {
        if (userState.getUserResponse().equalsIgnoreCase("/stop")) {
            userState.setNextAction(STOP);
            actionManager.doAction(userState, sender);
            dbMap.remove(userState.getChatId());
            context.commit();
        }

        switch (dbMap.get(userState.getChatId()).getNextAction()) {
            case CHOOSE_CURRENCY -> {
                log.info("Запрос валюты в телеграме {}", userState.getUserResponse());
                actionManager.doAction(userState,sender);
                userState.setNextAction(CHOOSE_QUOTA_CURRENCY);
                dbMap.put(userState.getChatId(), userState);

            }
            case CHOOSE_QUOTA_CURRENCY -> {
                log.info("Запрос котируемой валюты в телеграме {}", userState.getUserResponse());
                actionManager.doAction(userState,sender);
                userState.setNextAction(GET_RESULT);
                userState.getUserResponsesContainer().put(CHOOSE_CURRENCY, userState.getUserResponse());
                dbMap.put(userState.getChatId(), userState);
            }
            case GET_RESULT -> {
                log.info("Возвращаем результат вычислений в телеграм {}", userState.getUserResponse());
                userState.getUserResponsesContainer().put(CHOOSE_QUOTA_CURRENCY, userState.getUserResponse());
                actionManager.doAction(userState,sender);
            }
            default -> {
                userState.setNextAction(ERROR);
                actionManager.doAction(userState,sender);
            }
        }
    }

}
