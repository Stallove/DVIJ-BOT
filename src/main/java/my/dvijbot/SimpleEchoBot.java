package my.dvijbot;

import lombok.extern.slf4j.Slf4j;
import my.dvijbot.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class SimpleEchoBot extends TelegramLongPollingBot {
    private final BotConfig config;

    @Autowired
    public SimpleEchoBot(BotConfig config) {
        super(config.getToken());
        this.config = config;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String textFromUser = update.getMessage().getText();

            Long userId = update.getMessage().getChatId();
            User user = update.getMessage().getFrom();
            String userFirstName = update.getMessage().getFrom().getFirstName();


            //printing user messages
            log.info("[{}, {}] : {}", userId, userFirstName, textFromUser);

            //Building Request to be send to Telegram API
            SendMessage sendMessage = SendMessage.builder()
                    .chatId(update.getMessage().getChat().getId().toString())
                    .text("Hello, " + user.getFirstName() + ", I've received your text: " + textFromUser)
                    .build();
            try {
                //sending message via Telegram API
                this.sendApiMethod(sendMessage);
            } catch (TelegramApiException e) {
                log.error("Exception when sending message: ", e);
            }
        } else {
            log.warn("Unexpected update from user");
        }
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }
}
