package Diet;

import Bot.JSONParse;
import org.json.simple.parser.ParseException;

import java.sql.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProductsFinder extends JSONParse {

    private JSONParse jsonObj = new JSONParse();

    private List<HashMap> dayCalPFC;        // массив дневных блюд
    private List<HashMap> morningCalPFC;        // массив утренних блюд
    private List<HashMap> eveningCalPFC;        // массив вечерних блюд
    private List<HashMap> recipes;      // массив рецептов
    private double[] userRemCalPFC;     // остаток необходимых к употреблению БЖУК
    private List<String> allegryProducts;       // массив аллергических продуктов пользователя

    public ProductsFinder(double[] userRemCalPFC, List<String> allergyProd) throws ParseException {
        ClassLoader classLoader = getClass().getClassLoader();
        jsonObj.productsInit(classLoader.getResource("Day.json").getPath());
        dayCalPFC = jsonObj.convertJson();
        jsonObj.productsInit(classLoader.getResource("Morning.json").getPath());
        morningCalPFC = jsonObj.convertJson();
        jsonObj.productsInit(classLoader.getResource("Evening.json").getPath());
        eveningCalPFC = jsonObj.convertJson();
        jsonObj.productsInit(classLoader.getResource("Recipes.json").getPath());
        recipes = jsonObj.convertRecipes();
        this.userRemCalPFC = userRemCalPFC;
        this.allegryProducts = allergyProd;
    }

    /**
     * Получение блюда
     * @return Возвращает словарь, где ключ - название блюда, рецепт и ингредиенты, а значение - БЖУК
     */
    public HashMap<String[], double[]> getDishDaily() {
        String timeOfDay = getCurrentTimeOfDay();       // получение нынешнего времени суток
        HashMap<String[], double[]> result = new HashMap<>();

        switch (timeOfDay) {
            case "morning":
                result = getDishAndRecipe(morningCalPFC);
                break;
            case "day":
                result = getDishAndRecipe(dayCalPFC);
                break;
            case "evening":
                result = getDishAndRecipe(eveningCalPFC);
        }
        return result;
    }

    /**
     * Получение блюда и его рецепта
     * @param dishCalPFC массив блюд
     * @return Возвращает словарь, где ключ - название блюда, рецепт и ингредиенты, а значение - БЖУК
     */
    private HashMap<String[], double[]> getDishAndRecipe(List<HashMap> dishCalPFC) {
        String currentDishName = "";        // название нужного блюда
        double[] currentDishCalPFC = new double[4];     // БЖУК нужного блюда
        String[] recipe = new String[2];


        for (int i = 0; i < dishCalPFC.size(); i++) {
            Random rnd = new Random();
            HashMap<String, double[]> dish = dishCalPFC.get(rnd.nextInt(dishCalPFC.size()));        // получение рандомного блюда из массива блюд
            Map.Entry<String, double[]> currentDish = dish.entrySet().iterator().next();        // преобразование нужного словаря блюда

            String dishName = currentDish.getKey();     // получение название блюда
            double[] calPFC = currentDish.getValue();       // получение БЖУК блюда

            if (    userRemCalPFC[0] - calPFC[3] > 0 &&
                    userRemCalPFC[1] - calPFC[1] > 0 &&
                    userRemCalPFC[2] - calPFC[2] > 0 &&
                    userRemCalPFC[3] - calPFC[0] > 0 ) {
                currentDishName = dishName;
                currentDishCalPFC = calPFC;
                recipe = Reciptes.getRecipe(currentDishName, recipes);       // получаем рецепт подходящего блюда

                boolean allergy = checkAllergy(recipe[1]);      // сдержит ли еда продукты, вызывающие аллергическую реакцию

                if (!allergy) {
                    break;      // если нашли подходящее блюдо, то цикл прерывается
                }
            }
        }


        String[] recAndName = new String[] {currentDishName, recipe[0], recipe[1]};

        HashMap<String[], double[]> result = new HashMap<>();
        result.put(recAndName, currentDishCalPFC);

        return result;
    }

    /**
     * Получение ныншнего времени суток
     * @return Утро, день или вечер
     */
    private String getCurrentTimeOfDay() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String currentTime = dtf.format(now);
        int currentHour = Integer.parseInt(currentTime.substring(0, 2));

        if (currentHour >= 6 && currentHour < 12) {
            return "morning";
        } else if (currentHour >= 12 && currentHour < 15) {
            return "day";
        } else {
            return "evening";
        }
    }

    /**
     * Проверяет содержится ли в рецепте продукты, вызывающие аллергическую реакцию
     * @param ingredients Ингредиенты рецепта
     * @return Содержит ли аллергические продукты
     */
    private boolean checkAllergy(String ingredients) {
        List<String> ingred = Arrays.asList(ingredients.split("\n"));       // ингредиенты рецепта в виде массива

        for (int i = 0; i < ingred.size(); i++) {
            String idredient = ingred.get(i);
            int index = idredient.indexOf("-");
            ingred.set(i, idredient.substring(0, index - 1).toLowerCase());
        }

        boolean result = false;
        if (allegryProducts != null) {
            for(String allergy : allegryProducts) {
                if (ingred.contains(allergy)) {
                    result = true;
                }
            }
        }


        return result;
    }
}
