package currency.exchanger.telegram.bot.actions.impl;

import currency.exchanger.telegram.bot.utils.UserState;
import currency.exchanger.telegram.bot.actions.Action;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;

import static currency.exchanger.telegram.bot.utils.Constants.*;

@Component
public class StopAction implements Action {
    @Override
    public void action(UserState userState, SilentSender sender) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(userState.getChatId());
        sendMessage.setText("Увидимся в другой раз!");
        sendMessage.setReplyMarkup(new ReplyKeyboardRemove(true));
        sender.execute(sendMessage);
    }

    @Override
    public String actionName() {
        return STOP;
    }
}
