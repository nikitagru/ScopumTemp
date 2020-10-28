package Diet;

abstract public class Diet {
    /**
     * Подсчет дневной нормы калорий
     * @param gender
     * @param weight
     * @param growth
     * @param age
     * @param employment
     * @return Дневная норма калорий
     */
    protected double computeDailyCal(String gender, double weight, int growth, int age, double employment) {
        if (gender == "male") {
            double result = (10 * weight) + (6.25 * growth) - (5 * age + 5) * employment;
            return result;
        } else {
            double result = (10 * weight) + (6.25 * growth) - (5 * age - 161) * employment;
            return result;
        }
    }

    /**
     * Подсчет дневной нормы БЖУК
     * @param gender
     * @param weight
     * @param growth
     * @param age
     * @param employment
     * @return Дневная норма БЖУК
     */
    protected double[] computeUserCalPFC(String gender, double weight, int growth, int age, double employment) {
        double dailyCal = computeDailyCal(gender, weight, growth, age, employment);
        double[] userCalPFC;

        userCalPFC = new double[]{  dailyCal,
                                    Math.ceil(dailyCal * 0.3 / 4),
                                    Math.ceil(dailyCal * 0.3 / 9),
                                    Math.ceil(dailyCal * 0.4 / 4)};

        return userCalPFC;
    }


}
