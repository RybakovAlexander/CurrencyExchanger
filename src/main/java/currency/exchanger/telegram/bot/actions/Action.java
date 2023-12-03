package currency.exchanger.telegram.bot.actions;

import currency.exchanger.telegram.bot.utils.UserState;
import org.telegram.abilitybots.api.sender.SilentSender;

public interface Action {
    void action(UserState userState, SilentSender sender);
    String actionName();

}
