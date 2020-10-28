package Training;

import java.util.Scanner;

public class NormalTraining extends Training {
    public static void formatNormalTraining() {
        System.out.println("Вы выбрали раздел тренировки!" +
                "Чем хотите заняться сегодня?");
        System.out.println("1. Комплекс упражнений для развития тела \r\n" +
                "2. Комплекс упражнений для похудения \r\n" +
                "3. Упражнения для развития мышц рук \r\n" +
                "4. Упражнения для развития мышц пресса \r\n" +
                "5. Упражнения для развития мышц ног");

        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();

        switch (answer) {
            case "1":
                NormalTraining.developmentBody();
                break;
            case "2":
                NormalTraining.theSlim();
                break;
            case "3":
                NormalTraining.armsMuscles();
                break;
            case "4":
                NormalTraining.abdominalMuscles();
                break;
            case "5":
                NormalTraining.legsMuscles();
                break;
            default:
                System.out.println("Некорректно введенный запрос. Повторите попытку");
                break;
        }
    }

    private static void developmentBody() {
        System.out.println("Я думаю, что для развития вашего тела подойдут эти упражнения: \r\n" +
                " Подтягивания - Отжимания - Использование гантелей \r\n" +
                " Основная планка - Боковая планка - Качание пресса \r\n" +
                " Растягивание мышц пресса - Приседания \r\n" +
                " Выпады ногами - Зашагивания - Тяга на одной ноге");

    }

    private static void theSlim() {
        System.out.println("Я думаю, что для похудения вам подойдут эти упражнения: \r\n" +
                " Подтягивания - Отжимания - Использование гантелей \r\n" +
                " Основная планка - Боковая планка - Качание пресса \r\n" +
                " Растягивание мышц пресса - Приседания \r\n" +
                " Выпады ногами - Зашагивания - Тяга на одной ноге");
    }

    private static void armsMuscles() {
        System.out.println("Я думаю, что для развития мышц рук вам подойдут эти упражнения: \r\n" +
                " Подтягивания - Отжимания - Использование гантелей");
    }

    private static void abdominalMuscles() {
        System.out.println("Я думаю, что для развития мышц пресса вам подойдут эти упражнения: \r\n" +
                " Основная планка - Боковая планка \r\n" +
                " Качание пресса - Растягивание мышц пресса");
    }

    private static void legsMuscles() {
        System.out.println("Я думаю, что для развития мышц ног вам подойдут эти упражнения: \r\n" +
                " Приседания - Выпады ногами \r\n" +
                " Зашагивания - Тяга на одной ноге");
    }

}
