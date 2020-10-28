package Diet;
import Constants.Constants;
import java.util.Scanner;

public class DailyDiet extends Diet {
    public double[] remCalPFC = new double[4];      // оставшиеся БЖУК

    public DailyDiet(double weight, int growth, int age, String gender, double employment) {
        Constants.age = age;
        Constants.weight = weight;
        Constants.growth = growth;
        Constants.gender = gender;
        Constants.employment = employment;
    }

    /**
     * Попытка получить БЖУК пользователя
     * @return получилось или нет
     */
    public boolean tryGetEatenCalPFC() {
        System.out.println("Вы знаете какое количество КБЖУ вы сегодня уже употребили?(Да/Нет)");
        Scanner in = new Scanner(System.in);

        String userChoice = in.nextLine();
        userChoice = userChoice.replaceAll("\\s+","");
        userChoice = userChoice.toLowerCase();

        boolean isSuccess = true;

        switch (userChoice) {
            case "да":
                System.out.println("Напишите в формате К_Б_Ж_У (без пробелов и через подчеркивание)");

                String calPFC = in.nextLine();
                calPFC = calPFC.replaceAll("\\s+","");

                double[] userEatenCalPFC = convertUserCalPFC(calPFC);       // конвертация БЖУК
                computeUserRemCalPFC(userEatenCalPFC);      // подсчет оставшихся к употреблению
                break;
            case "нет":
                System.out.println("Давайте тогда посчитаем сами.");
                isSuccess = false;
                break;
        }
        return isSuccess;
    }

    /**
     * Подсчет оставшихся БЖУК к употреблению
     * @param userEatenCalPFC Употребленные БЖУК на данный момент
     */
    private void computeUserRemCalPFC(double[] userEatenCalPFC) {
        double[] userDailyCalPfc = computeUserCalPFC(Constants.gender, Constants.weight, Constants.growth, Constants.age, Constants.employment);      // получение дневной нормы БЖУК пользователя

        remCalPFC = new double[]{  userDailyCalPfc[0] - userEatenCalPFC[0],
                                        userDailyCalPfc[1] - userEatenCalPFC[1],
                                        userDailyCalPfc[2] - userEatenCalPFC[2],
                                        userDailyCalPfc[3] - userEatenCalPFC[3]};

        System.out.println("Вам осталось необходимо употребить:");
        System.out.println(remCalPFC[0] + " " + "калорий");
        System.out.println(remCalPFC[1] + " " + "белков");
        System.out.println(remCalPFC[2] + " " + "жиров");
        System.out.println(remCalPFC[3] + " " + "углеводов");

    }

    /**
     * Конвертация БЖУК
     * @param calPFC введенное БЖУК пользователя
     * @return массив БЖУК
     */
    private double[] convertUserCalPFC(String calPFC) {
        String[] userCalPFC = calPFC.split("_");
        double[] finUserCalPfc = new double[4];

        for(int i = 0; i < 4; i++) {
            finUserCalPfc[i] = Double.parseDouble(userCalPFC[i]);
        }
        return finUserCalPfc;
    }

}
