package my.dvijbot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Slf4j
@SpringBootApplication
public class DvijBotApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DvijBotApplication.class, args);

		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			log.info("Starting Bot");
			TelegramLongPollingBot simpleEchoBot = context.getBean(SimpleEchoBot.class);
			telegramBotsApi.registerBot(simpleEchoBot);
		} catch (TelegramApiException e) {
			log.error("Error while starting the bot", e);
		}
		log.info("Bot ready");
	}
}
