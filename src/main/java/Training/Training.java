package Training;
import Constants.Constants;

abstract public class Training {
    protected double computeTrainingCal(String gender, double weight, int growth, int age, double employment) {
        if (Constants.gender == "мужчина") {
            double result = (1 * weight) + (0.05 * growth) - (0.01 * age) * employment;
            return result;
        } else {
            double result = (1 * weight) + (0.01 * growth) - (0.01 * age) * employment;
            return result;
        }
    }
}
