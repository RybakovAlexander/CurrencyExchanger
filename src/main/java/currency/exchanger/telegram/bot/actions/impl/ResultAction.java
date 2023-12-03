package currency.exchanger.telegram.bot.actions.impl;

import currency.exchanger.dtos.CryptoCurrencyListingsLatest;
import currency.exchanger.services.coinmarketservice.CoinMarketService;
import currency.exchanger.telegram.bot.utils.UserState;
import currency.exchanger.telegram.bot.actions.Action;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.abilitybots.api.sender.SilentSender;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static currency.exchanger.telegram.bot.utils.Constants.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class ResultAction implements Action {

    private final CoinMarketService coinMarketService;
    @Override
    public void action(UserState userState, SilentSender sender) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(userState.getChatId());
        String price = coinMarketService.getOneCurrencyPrice(
                userState.getUserResponsesContainer().get(CHOOSE_CURRENCY),
                userState.getUserResponsesContainer().get(CHOOSE_QUOTA_CURRENCY));
        sendMessage.setText("Ответ. Цена валюты " + price);
        sender.execute(sendMessage);
    }

    @Override
    public String actionName() {
        return GET_RESULT;
    }
}
