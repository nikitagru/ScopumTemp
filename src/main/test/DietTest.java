

import Diet.ProductsFinder;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import Diet.ProductsFinder;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DietTest {
    private double getCallories(ProductsFinder finder) {
        HashMap<String[], double[]> result = finder.getDishDaily();
        Map.Entry<String[], double[]> currentDish = result.entrySet().iterator().next();
        double[] dishCalPFC = currentDish.getValue();

        return dishCalPFC[0];
    }
    @Test
    void simple() throws ParseException {
        double[] calPFC = new double[] {500.0, 12.2, 14.5, 45.0};
        ProductsFinder finder = new ProductsFinder(calPFC, null);
        double result = getCallories(finder);
        assertTrue(result > 0);
    }

    @Test
    void simpleFasle() throws ParseException {
        double[] calPFC = new double[] {0.0, 12.2, 14.5, 45.0};
        ProductsFinder finder = new ProductsFinder(calPFC, null);
        double result = getCallories(finder);
        assertTrue(result == 0.0);
    }
}
