import org.json.simple.parser.ParseException;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import java.io.IOException;
import java.util.Scanner;

public class Main /*extends TelegramLongPollingBot*/ {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {
        // главный класс для запуска бота и инициализации пользователя
//        ApiContextInitializer.init();
//        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//
//        try {
//            telegramBotsApi.registerBot((LongPollingBot) new Bot());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }




        BotController bot = new BotController();
        User user = new User();

        while (true) {
            System.out.println("Ваши параметры сохранены!");
            System.out.println("Что бы вы хотели сделать?");
            System.out.println(" Дневная диета \r\n Многодневная диета \r\n Тренировка \r\n Профессиональная тренировка");

            Scanner in = new Scanner(System.in);
            String userChoice = in.nextLine();

            switch (userChoice) {
                case "Дневная диета":
                    bot.dailyDiet(user);
                    break;
                case "Многодневная диета":
                    bot.longDiet(user);
                    break;
                case "Тренировка":
                    bot.normalTraining();
                    break;
                case "Профессиональная тренировка":
                    bot.professionalTraining();
                    break;
                default:
                    System.out.println("Некорректно введенный запрос. Повторите попытку");
                    break;
            }
        }
    }


//    @Override
//    public void onUpdateReceived(Update update) {
//        Message msg = update.getMessage();
//        switch (msg.getText()) {
//            case "/start":
//                sendMsg(msg, "Привет, меня зовут Scopum!");
//                break;
//            case "/help":
//                sendMsg(msg, "Я помогу тебе привнести в твою жизнь здоровый образ жизни");
//                break;
//        }
//    }
//
//    private void sendMsg(Message msg, String text) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);
//        sendMessage.setChatId(msg.getChatId().toString());
//        sendMessage.setReplyToMessageId(msg.getMessageId());
//        sendMessage.setText(text);
//
//        try {
//
//        }
//    }
//
//    @Override
//    public String getBotUsername() {
//        return "ScopumBot";
//    }
//
//    @Override
//    public String getBotToken() {
//        return "1344975423:AAEzh7soTgC6_W5P655XZxOQvRbBr5G1K2A";
//    }
}
