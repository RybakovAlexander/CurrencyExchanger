package currency.exchanger.telegram.bot.actions.impl;

import currency.exchanger.telegram.bot.utils.UserState;
import currency.exchanger.telegram.bot.actions.Action;
import currency.exchanger.telegram.bot.utils.KeyBoardFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import static currency.exchanger.telegram.bot.utils.Constants.*;


@Component
@RequiredArgsConstructor
public class ChooseCurrencyAction implements Action {


    @Override
    public void action(UserState userState, SilentSender sender) {
        promptWithKeyboardForState(userState.getChatId(),  userState.getUserResponse() + " Какая крипто-валюта интересует?",
                KeyBoardFactory.getKeyboard("BTC", "TON"),
                sender);

    }

    @Override
    public String actionName() {
        return CHOOSE_CURRENCY;
    }

    private void promptWithKeyboardForState(long chatId, String text, ReplyKeyboard currency, SilentSender sender) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(currency);
        sender.execute(sendMessage);
    }
}
