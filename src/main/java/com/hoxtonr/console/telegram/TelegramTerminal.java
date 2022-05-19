package com.hoxtonr.console.telegram;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.IOException;
import java.util.List;


public class TelegramTerminal {
    TelegramBot bot;

    public TelegramTerminal() {
        bot = new TelegramBot("1849653958:AAEoZ32u6Ux_6Jnvefc0A7F465VxROST6xU");
    }
    public boolean sendMessage(long chatID, String text, int replyID){
        SendMessage request = new SendMessage(chatID, text)
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(true)
                .disableNotification(true)
                .replyToMessageId(replyID)
                .replyMarkup(new ForceReply());
        SendResponse sendResponse = bot.execute(request);
        boolean ok = sendResponse.isOk();
        Message message = sendResponse.message();
        System.out.println(message);
        return ok;
    }
    public void updateListener(){
        bot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> updates) {

                System.out.println(updates.get(0).message().text());
                System.out.println(updates.get(0).message().chat().username());
                System.out.println(updates.get(0).message().date());
                System.out.println(updates.get(0).message().from());
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });
    }
    public void removeUpdateListener(){
        try {
            bot.removeGetUpdatesListener();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TelegramTerminal m = new TelegramTerminal();
        m.sendMessage(1785547669,"哈哈",0);
        m.updateListener();

    }

}
