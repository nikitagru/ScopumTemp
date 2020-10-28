package Bot;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException {

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
}
