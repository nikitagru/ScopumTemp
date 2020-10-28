import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class User {
    private String name; // Имя пользователя
    private int age; // Возраст пользователя
    private double weight; // Вес пользователя
    private int growth; // Рост пользователя
    private Gender gender; // Пол пользователя
    private double employment; // Уровень занятости пользователя(1-5)
    private boolean isCorrect = true;
    private List<String> allergyProducts;

    public User() {
        init();
    }

    /**
     * Инициализация пользователя
     */
    private void init() {
        do {
            Scanner in = new Scanner(System.in);

            if (this.name == null) {
                System.out.println("Введите ваше имя");
                String name = in.nextLine();
                setName(name);
                if (!isCorrectData()) {
                    continue;
                }
            }


            if (this.age == 0) {
                System.out.println("Введите ваш возраст");
                setAge(in.nextLine());
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (this.weight == 0.0) {
                System.out.println("Введите ваш вес");
                setWeight(in.nextLine());
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (this.growth == 0) {
                System.out.println("Введите ваш рост");
                setGrowth(in.nextLine());
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (this.gender == null) {
                System.out.println("Вы мужчина или женщина?");
                String gender = in.nextLine();
                setGender(gender);
                if (!isCorrectData()) {
                    continue;
                }
            }

            if (this.employment == 0.0) {
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

            if (this.allergyProducts == null) {
                System.out.println("Вы имеете аллергию на какие-нибудь продукты?(да/нет)");
                String allergy = in.nextLine();
                allergy = allergy.replaceAll(" ", "");
                allergy = allergy.toLowerCase();

                if (allergy.equals("да")) {
                    isCorrect = true;
                    setAllergyProducts();
                } else if (allergy.equals("нет")) {
                    this.allergyProducts = null;
                    isCorrect = true;
                } else {
                    System.out.println("Вы ввели некорретный ответ. Напишите, пожалуйста, снова.");
                    isCorrect = false;
                }
                if (!isCorrectData()) {
                    continue;
                }
            }


        } while (!isCorrectData());
    }

    private void setAllergyProducts() {
        System.out.println("Введите список продуктов через пробел в начальной форме. Вместо \"огурцы\" напишите просто \"огурец\"");
        Scanner in = new Scanner(System.in);
        String allergyProd = in.nextLine();
        if (allergyProd != null && !allergyProd.equals("")) {
            this.allergyProducts = Arrays.asList(allergyProd.split(" "));
        } else {
            System.out.println("Продукты были введены в некорреткной форме. Попробуйте снова");
            isCorrect = false;
        }

    }

    public List<String> getAllergyProducts() {
        return this.allergyProducts;
    }

    /**
     * Проверяет корректно ли введены данные пользователем
     * @return true - если все данные введены корректно, false - если данные введены некорректно
     */
    private boolean isCorrectData() {
        return isCorrect;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        name = name.replaceAll("\\s+","");
        if (name != null && !name.equals("")) {
            this.name = name;
            isCorrect = true;
        } else {
            System.out.println("В качестве имени была введена пустая строка. Пожалуйста, напишите корректное имя");
            isCorrect = false;
        }

    }

    public int getAge() {
        return age;
    }

    private void setAge(String ageIn) {
        int age = 0;
        if (ageIn != null && !ageIn.equals("")) {
            age = Integer.parseInt(ageIn);
            if (age > 122 || age <= 0) {
                System.out.println("Вы ввели некорректный возраст, попробуйте снова");
                isCorrect = false;
            } else {
                this.age = age;
                isCorrect = true;
            }
        } else {
            System.out.println("Вы ввели некорректный возраст, попробуйте снова");
            isCorrect = false;

        }
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(String weightIn) {
        double weight;
        if (weightIn != null && !weightIn.equals("")) {
            weight = Double.parseDouble(weightIn);
            if (weight <= 0.0d) {
                System.out.println("Вы ввели некорректный вес, попробуйте снова");
                isCorrect = false;
            } else {
                this.weight = weight;
                isCorrect = true;
            }
        } else {
            System.out.println("Вы ввели некорректный вес, попробуйте снова");
            isCorrect = false;
        }
    }

    public int getGrowth() {
        return growth;
    }

    private void setGrowth(String growthIn) {
        int growth;
        if (growthIn != null && !growthIn.equals("")) {
            growth = Integer.parseInt(growthIn);
            if (growth <= 0) {
                System.out.println("Вы ввели некорректный рост, попробуйте снова");
                isCorrect = false;
            } else {
                this.growth = growth;
                isCorrect = true;
            }
        } else {
            System.out.println("Вы ввели некорректный рост, попробуйте снова");
            isCorrect = false;
        }
    }

    public String getGender() {
        return gender.toString();
    }

    private void setGender(String gender) {
        if (gender != null && !gender.equals("")) {
            gender = gender.toLowerCase();
            gender = gender.replaceAll("\\s+","");
            if (gender.equals("мужчина")) {
                this.gender = Gender.male;
                isCorrect = true;
            } else if (gender.equals("женщина")){
                this.gender = Gender.female;
                isCorrect = true;
            } else {
                System.out.println("Вы ввели некорретный пол, попробуйте снова");
                isCorrect = false;
            }
        } else {
            System.out.println("Вы ввели некорретный пол, попробуйте снова");
            isCorrect = false;
        }
    }

    public double getEmployment() {
        return employment;
    }

    private void setEmployment(String employmentIn) {
        int employment = 0;
        if (!employmentIn.equals("")) {
            try {
                employment = Integer.parseInt(employmentIn);
            }
            catch (NumberFormatException e) {
                System.out.println("Вы ввели не число, попробуйте снова");
                isCorrect = false;
            }

            if (employment > 0 && employment < 6) {
                switch (employment) {
                    case 1:
                        this.employment = 1.2;
                        break;
                    case 2:
                        this.employment = 1.375;
                        break;
                    case 3:
                        this.employment = 1.55;
                        break;
                    case 4:
                        this.employment = 1.725;
                        break;
                    case 5:
                        this.employment = 1.9;
                        break;
                }
            } else {
                System.out.println("Введено число не из заданого диапазона");
                isCorrect = false;
            }
        } else {
            System.out.println("Вы ввели некорретное значение, введите число от 1-5");
            isCorrect = false;
        }
    }
}
