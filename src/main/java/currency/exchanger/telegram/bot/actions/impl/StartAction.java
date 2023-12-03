package currency.exchanger.telegram.bot.actions.impl;

import currency.exchanger.telegram.bot.utils.UserState;
import currency.exchanger.telegram.bot.actions.Action;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.Map;

import static currency.exchanger.telegram.bot.utils.Constants.START;


@Component
@RequiredArgsConstructor
public class StartAction implements Action {
    public static final String START_TEXT = "Привет, я бот, для работы с курсами валют и криптовалют. Как тебя зовут?";
    private final Map<Long, UserState> dbContext;

    @Override
    public void action(UserState userState, SilentSender sender) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(userState.getChatId());
        sendMessage.setText(START_TEXT);
        sender.execute(sendMessage);
    }

    @Override
    public String actionName() {
        return START;
    }
}
