package Bot;

import Diet.DailyDiet;
import Diet.LongDiet;
import Training.NormalTraining;
import Training.ProfessionalTraining;
import org.json.simple.parser.ParseException;

import java.io.IOException;


public class BotController implements BotFunctionality {

    public BotController() {
        System.out.println("Привет! Меня зовут Scopum. " +
                "Я бот, который поможет тебе орагнизовать в твоем обычном дне элементы здорового образа жизни. " +
                "Давай познакомимся!");
    }

    @Override
    public void dailyDiet(User user) {
        double weight = user.getWeight();
        int growth = user.getGrowth();
        int age = user.getAge();
        String gender = user.getGender();
        double employment = user.getEmployment();

        DailyDiet dailyDiet = new DailyDiet(weight, growth, age, gender, employment);
        boolean isGetCalPFC = dailyDiet.tryGetEatenCalPFC();

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
    public void normalTraining() {
        NormalTraining nTraining = new NormalTraining();
        nTraining.formatNormalTraining();

    }

    @Override
    public void professionalTraining() {
        ProfessionalTraining pTraining = new ProfessionalTraining();
        pTraining.formatProfessionalTraining();
    }



}
