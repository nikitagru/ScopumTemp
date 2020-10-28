package Bot;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import Constants.Constants;

public class User {

    public User() {
        init();
    }
    /**
     * Инициализация пользователя
     */
    private void init() {
        do {
            Scanner in = new Scanner(System.in);
            if (Constants.name == null) {
                System.out.println("Введите ваше имя");
                String name = in.nextLine();
                setName(name);
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (Constants.age == 0) {
                System.out.println("Введите ваш возраст");
                setAge(in.nextLine());
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (Constants.weight == 0.0) {
                System.out.println("Введите ваш вес");
                setWeight(in.nextLine());
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (Constants.growth == 0) {
                System.out.println("Введите ваш рост");
                setGrowth(in.nextLine());
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (Constants.gender == null) {
                System.out.println("Вы мужчина или женщина?");
                String gender = in.nextLine();
                setGender(gender);
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (Constants.employment == 0.0) {
                System.out.println("Какой у вас дневной образ жизни? Напишите число от 1 до 5");
                System.out.println("\"Сидячий без нагрузок\"--" +
                        "\"Тренировки  1-3 раза в неделю\"--" +
                        "\"Занятия 3-5 дней в неделю\"--" +
                        "\"Интенсивные тренировки 6-7 раз в неделю\"--" +
                        "\"Спортсмены, выполняющие упражнения чаще, чем раз в день(несколько тренировок за день)\"");

                setEmployment(in.nextLine());
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (Constants.allergyProducts == null) {
                System.out.println("Вы имеете аллергию на какие-нибудь продукты?(да/нет)");
                String allergy = in.nextLine();
                allergy = allergy.replaceAll(" ", "");
                allergy = allergy.toLowerCase();

                if (allergy.equals("да")) {
                    Constants.isCorrect = true;
                    setAllergyProducts();
                } else if (allergy.equals("нет")) {
                    Constants.allergyProducts = null;
                    Constants.isCorrect = true;
                } else {
                    System.out.println("Вы ввели некорретный ответ. Напишите, пожалуйста, снова.");
                    Constants.isCorrect = false;
                }
                if (!isCorrectData()) {
                    continue;
                }
            }
        } while (!isCorrectData());
    }

    private void setAllergyProducts() {
        System.out.println("Введите список продуктов через пробел в начальной форме." +
                " Вместо \"огурцы\" напишите просто \"огурец\"");
        Scanner in = new Scanner(System.in);
        String allergyProd = in.nextLine();
        if (allergyProd != null && !allergyProd.equals("")) {
            Constants.allergyProducts = Arrays.asList(allergyProd.split(" "));
        } else {
            System.out.println("Продукты были введены в некорреткной форме. Попробуйте снова");
            Constants.isCorrect = false;
        }
    }

    public List<String> getAllergyProducts() {
        return Constants.allergyProducts;
    }
    /**
     * Проверяет корректно ли введены данные пользователем
     * @return true - если все данные введены корректно, false - если данные введены некорректно
     */
    private boolean isCorrectData() {
        return Constants.isCorrect;
    }

    public String getName() {
        return Constants.name;
    }

    private void setName(String name) {
        name = name.replaceAll("\\s+","");
        if (name != null && !name.equals("")) {
            Constants.name = name;
            Constants.isCorrect = true;
        } else {
            System.out.println("В качестве имени была введена пустая строка. Пожалуйста, напишите корректное имя");
            Constants.isCorrect = false;
        }

    }

    public int getAge() {
        return Constants.age;
    }

    private void setAge(String ageIn) {
        int age = 0;
        if (ageIn != null && !ageIn.equals("")) {
            age = Integer.parseInt(ageIn);
            if (age > 122 || age <= 0) {
                System.out.println("Вы ввели некорректный возраст, попробуйте снова");
                Constants.isCorrect = false;
            } else {
                Constants.age = age;
                Constants.isCorrect = true;
            }
        } else {
            System.out.println("Вы ввели некорректный возраст, попробуйте снова");
            Constants.isCorrect = false;

        }
    }

    public double getWeight() {
        return Constants.weight;
    }

    private void setWeight(String weightIn) {
        double weight;
        if (weightIn != null && !weightIn.equals("")) {
            weight = Double.parseDouble(weightIn);
            if (weight <= 0.0d) {
                System.out.println("Вы ввели некорректный вес, попробуйте снова");
                Constants.isCorrect = false;
            } else {
                Constants.weight = weight;
                Constants.isCorrect = true;
            }
        } else {
            System.out.println("Вы ввели некорректный вес, попробуйте снова");
            Constants.isCorrect = false;
        }
    }

    public int getGrowth() {
        return Constants.growth;
    }

    private void setGrowth(String growthIn) {
        int growth;
        if (growthIn != null && !growthIn.equals("")) {
            growth = Integer.parseInt(growthIn);
            if (growth <= 0) {
                System.out.println("Вы ввели некорректный рост, попробуйте снова");
                Constants.isCorrect = false;
            } else {
                Constants.growth = growth;
                Constants.isCorrect = true;
            }
        } else {
            System.out.println("Вы ввели некорректный рост, попробуйте снова");
            Constants.isCorrect = false;
        }
    }

    public String getGender() {
        return Constants.gender.toString();
    }

    private void setGender(String gender) {
        if (gender != null && !gender.equals("")) {
            gender = gender.toLowerCase();
            gender = gender.replaceAll("\\s+","");
            if (gender.equals("мужчина")) {
                Constants.isCorrect = true;
            } else if (gender.equals("женщина")){
                Constants.isCorrect = true;
            } else {
                System.out.println("Вы ввели некорретный пол, попробуйте снова");
                Constants.isCorrect = false;
            }
        } else {
            System.out.println("Вы ввели некорретный пол, попробуйте снова");
            Constants.isCorrect = false;
        }
    }

    public double getEmployment() {
        return Constants.employment;
    }

    private void setEmployment(String employmentIn) {
        int employment = 0;
        if (!employmentIn.equals("")) {
            try {
                employment = Integer.parseInt(employmentIn);
            }
            catch (NumberFormatException e) {
                System.out.println("Вы ввели не число, попробуйте снова");
                Constants.isCorrect = false;
            }

            if (employment > 0 && employment < 6) {
                switch (employment) {
                    case 1:
                        Constants.employment = 1.2;
                        break;
                    case 2:
                        Constants.employment = 1.375;
                        break;
                    case 3:
                        Constants.employment = 1.55;
                        break;
                    case 4:
                        Constants.employment = 1.725;
                        break;
                    case 5:
                        Constants.employment = 1.9;
                        break;
                }
            } else {
                System.out.println("Введено число не из заданого диапазона");
                Constants.isCorrect = false;
            }
        } else {
            System.out.println("Вы ввели некорретное значение, введите число от 1-5");
            Constants.isCorrect = false;
        }
    }
}
