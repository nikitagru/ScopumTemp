package Diet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reciptes {
    /**
     * Конвертирует массив JSON-объектов в массив словарей
     * @param reciptesArray массив JSON-объектов
     * @return массив словарей
     */
    public static List<HashMap> convertToArray(List<Object> reciptesArray) {
        List<HashMap> converteredProduct = new ArrayList<>();
        for (int i = 0; i < reciptesArray.size(); i++) {
            Object temp = reciptesArray.get(i);       // получение i-го рецепта
            temp = temp.toString();
            converteredProduct.add(convertToMap((String) temp));     // конвертация рецепта в словарь
        }

        return converteredProduct;
    }

    /**
     * Конвертация рецепта в словарь
     * @param product Строка рецепта(название и рецепт с ингридиентами)
     * @return Возвращает словарь, где ключ - название блюда, значение - рецепт и ингридиенты
     */
    private static HashMap<String, String[]> convertToMap(String product) {
        product = product.replaceAll("__", "\n");
        product = product.replaceAll("_", " ");

        String[] recipe = product.split("=");       // первое значение - название блюда, второе - рецепт и ингредиенты
        recipe[1] = recipe[1].substring(1);
        recipe[1] = recipe[1].replaceAll("}", "");

        String ingrText = recipe[1].substring(recipe[1].lastIndexOf(",") + 1);
        String recText = recipe[1].substring(0, recipe[1].lastIndexOf(","));

        String[] recipeIngr = new String[]{recText, ingrText};     // получение элементов через запятую
        String[] recipeText = new String[2];        // текст рецепта и ингредиенты (1 - рецепт, 2 - ингредиенты)

        for (int i = 0; i < 2; i++) {
            recipeIngr[i] = recipeIngr[i].replaceAll("\"","");
            String value = recipeIngr[i].split(":")[1];
            recipeText[i] = value;
        }

        HashMap<String, String[]> result = new HashMap<>();
        result.put(recipe[0], recipeText);      // первое значение - название блюда, второе - рецепт и ингредиенты

        return result;
    }

    /**
     * Получение рецепта
     * @param dishName Название блюда
     * @return Рецепт и ингредиенты
     */
    public static String[] getRecipe(String dishName, List<HashMap> recipes) {
        String[] result = new String[2];

        for (int i = 0; i < recipes.size(); i++) {      // идем по всем рецептам
            HashMap recipe = recipes.get(i);

            if (recipe.containsKey(dishName)) {     // проверяем у каждого совпадает ли название с входящим
                result = (String[]) recipe.get(dishName);
                break;
            }
        }

        return result;
    }
}
