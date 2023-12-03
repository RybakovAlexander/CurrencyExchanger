package currency.exchanger.telegram.bot.actions;


import currency.exchanger.telegram.bot.utils.UserState;
import org.springframework.stereotype.Service;
import org.telegram.abilitybots.api.sender.SilentSender;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ActionManager {

    private final List<Action> actionList;
    private final Map<String, Action> actionMap;


    public ActionManager(List<Action> actionList){
        this.actionList = actionList;
        actionMap = actionList.stream()
                .collect(Collectors.toMap(Action::actionName, Function.identity()));
    }

    public void doAction(UserState userState, SilentSender sender){
        actionMap.get(userState.getNextAction())
                .action(userState, sender);
    }
}
