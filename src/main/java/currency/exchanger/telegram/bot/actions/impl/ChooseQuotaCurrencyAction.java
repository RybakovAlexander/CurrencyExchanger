package currency.exchanger.telegram.bot.actions.impl;

import currency.exchanger.telegram.bot.utils.UserState;
import currency.exchanger.telegram.bot.actions.Action;
import currency.exchanger.telegram.bot.utils.KeyBoardFactory;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import static currency.exchanger.telegram.bot.utils.Constants.*;
@Component
public class ChooseQuotaCurrencyAction implements Action {
    @Override
    public void action(UserState userState, SilentSender sender) {
        promptWithKeyboardForState(userState.getChatId(),  userState.getUserResponse() + " В какую валюту будем конвертировать?",
                KeyBoardFactory.getKeyboard("USD", "RUB"),
                sender);
    }

    @Override
    public String actionName() {
        return CHOOSE_QUOTA_CURRENCY;
    }

    private void promptWithKeyboardForState(long chatId, String text, ReplyKeyboard currency, SilentSender sender) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(currency);
        sender.execute(sendMessage);
    }
}
