public class FinancialForecaster {
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Use a for loop to simulate recursion for variety
        double value = currentValue;
        for (int i = 0; i < periods; i++) {
            value *= (1 + growthRate);
        }
        return value;
    }
    public static double calculateFutureValueOptimized(double currentValue, double growthRate, int periods) {
        // Use a bottom-up approach instead of recursion
        double[] memo = new double[periods + 1];
        memo[0] = currentValue;
        for (int i = 1; i <= periods; i++) {
            memo[i] = memo[i - 1] * (1 + growthRate);
        }
        return memo[periods];
    }
    public static double calculateFutureValueTailRec(double currentValue, double growthRate, int periods) {
        // Use a while loop to simulate tail recursion
        double accumulator = currentValue;
        int count = periods;
        while (count > 0) {
            accumulator *= (1 + growthRate);
            count--;
        }
        return accumulator;
    }
}
