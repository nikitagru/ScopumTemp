package Diet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dish {
    /**
     * Конвертирует массив JSON-объектов в массив словарей
     * @param productsArray массив JSON-объектов
     * @return массив словарей
     */
    public static List<HashMap> convertToArray(List<Object> productsArray){
        List<HashMap> converteredProduct = new ArrayList<>();       // массив сконвертированных словарей(вовзращаемое значение)

        for (int i = 0; i < productsArray.size(); i++) {
            Object temp = productsArray.get(i);        // получение i-го блюда
            temp = temp.toString();
            converteredProduct.add(convertToMap((String) temp));        // конвертация блюда в словарь
        }

        return converteredProduct;
    }

    /**
     * Конвертация блюда в словарь
     * @param product Строка блюда(название и бжук)
     * @return Возвращает словарь, где ключ - название блюда, значение - БЖУК
     */
    private static HashMap<String, double[]> convertToMap(String product) {
        product = product.replaceAll("_", " ");     // замена _ на пробел
        product = product.replaceAll("__", "\n");       // замена __ на перенос строки

        String[] prodcutCalPFC = product.split("=");        // 0 - название, 1 - БЖУК
        prodcutCalPFC[1] = prodcutCalPFC[1].substring(1);
        prodcutCalPFC[1] = prodcutCalPFC[1].replaceAll("}", "");        // удаление обрамляющих скобок у БЖУК

        String[] caloriesPFC = prodcutCalPFC[1].split(",");     // разделение всех строк БЖУК
        double[] calPFC = new double[4];

        for (int i = 0; i < 4; i++) {
            caloriesPFC[i] = caloriesPFC[i].replaceAll("\"","");
            String value = caloriesPFC[i].split(":")[1];
            calPFC[i] = Double.parseDouble(value);      // добавление в массив одно из БЖУК
        }

        HashMap<String, double[]> result = new HashMap<>();
        result.put(prodcutCalPFC[0], calPFC);

        return result;
    }
}
