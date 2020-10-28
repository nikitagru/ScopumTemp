package Diet;

import Constants.Constants;

public class LongDiet extends Diet {

    public LongDiet(double weight, int growth, int age, String gender, double employment) {
        Constants.age = age;
        Constants.weight = weight;
        Constants.growth = growth;
        Constants.gender = gender;
        Constants.employment = employment;
    }

    public void initLongDiet() {
        double[] userCalPFC = computeUserCalPFC(Constants.gender, Constants.weight, Constants.growth, Constants.age, Constants.employment);

        System.out.println("Ваша дневная норма КБЖУ:\n " +
                            userCalPFC[0] + "\n" + " " + "калорий" +
                            userCalPFC[1] + "\n" + " " + "белков" +
                            userCalPFC[2] + "\n" + " " + "жиров" +
                            userCalPFC[3] + "\n" + " " + "углеводов");


    }
}
