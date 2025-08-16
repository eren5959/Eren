package com.example.telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        // ✅ Username from Render env var
        return System.getenv("BOT_USERNAME");
    }

    @Override
    public String getBotToken() {
        // ✅ Token from Render env var
        return System.getenv("BOT_TOKEN");
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String text = update.getMessage().getText();

            String reply = "You said: " + text;

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(reply);

            try {
                execute(message); // send the reply
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
