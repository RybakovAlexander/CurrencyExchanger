package currency.exchanger.telegram.bot.utils;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Arrays;
import java.util.List;

public class KeyBoardFactory {
    public static ReplyKeyboard getKeyboard(String...args){
        KeyboardRow row = new KeyboardRow();
        Arrays.stream(args)
                .forEachOrdered(row::add);
        return new ReplyKeyboardMarkup(List.of(row));
    }

}
