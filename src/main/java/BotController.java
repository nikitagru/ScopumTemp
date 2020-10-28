import Diet.DailyDiet;
import Diet.LongDiet;
import Diet.ProductsFinder;
import Training.NormalTraining;
import Training.ProfessionalTraining;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class BotController implements BotFunctionality {

    public BotController() {
        System.out.println("Привет! Меня зовут Scopum. " +
                "Я бот, который поможет тебе орагнизовать в твоем обычном дне элементы здорового образа жизни. " +
                "Давай познакомимся!");
    }

    @Override
    public void dailyDiet(User user) throws IOException, ParseException {
        double weight = user.getWeight();
        int growth = user.getGrowth();
        int age = user.getAge();
        String gender = user.getGender();
        double employment = user.getEmployment();

        DailyDiet dailyDiet = new DailyDiet(weight, growth, age, gender, employment);
        boolean isGetCalPFC = dailyDiet.tryGetEatenCalPFC();
        /*
        List<String> userAllergyProd = user.getAllergyProducts();
        ProductsFinder finder = new ProductsFinder(dailyDiet.remCalPFC, userAllergyProd);
        HashMap<String[], double[]> dish = finder.getDishDaily();
        Map.Entry<String[], double[]> currentDish = dish.entrySet().iterator().next();

        String dishName = currentDish.getKey()[0];

        String recipe = currentDish.getKey()[1];
        String ingred = currentDish.getKey()[2];

        double[] calPFC = currentDish.getValue();



        if (calPFC[0] == 0.0) {
                System.out.println("Мы не смогли ничего найти подходящего в нашей базе данных рецептов. Возможно, вы уже употребили достаточно пищи сегодня");
        } else {
            System.out.println("Могу предложить вам этот рецепт:\n" +
                    dishName + "\n" +
                    recipe + "\n" +
                    ingred + "\n" +
                    "БЖУК данного рецепта:\n" +
                    calPFC[0] + " " + "белков" + "\n" +
                    calPFC[1] + " " + "жиров" + "\n" +
                    calPFC[2] + " " + "углеводов" + "\n" +
                    calPFC[3] + " " + "калорий" + "\n");

        }
        */

    }


    @Override
    public void longDiet(User user) {
        double weight = user.getWeight();
        int growth = user.getGrowth();
        int age = user.getAge();
        String gender = user.getGender();
        double employment = user.getEmployment();

        LongDiet longDiet = new LongDiet(weight, growth, age, gender, employment);

        longDiet.initLongDiet();
    }

    @Override
    public void normalTraining() throws IOException, InterruptedException {
        NormalTraining nTraining = new NormalTraining();

        nTraining.formatNormalTraining();

    }

    @Override
    public void professionalTraining() throws IOException, InterruptedException {
        ProfessionalTraining pTraining = new ProfessionalTraining();

        pTraining.formatProfessionalTraining();
    }



}
