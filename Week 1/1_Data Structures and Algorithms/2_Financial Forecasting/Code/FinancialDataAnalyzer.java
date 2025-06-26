public class FinancialDataAnalyzer {
    public static double calculateAverageGrowthRate(double[] historicalValues) {
        if (historicalValues == null || historicalValues.length < 2) {
            throw new IllegalArgumentException("Need at least 2 historical values");
        }
        double totalGrowth = 0;
        int i = 1;
        while (i < historicalValues.length) {
            double periodGrowth = (historicalValues[i] - historicalValues[i - 1]) / historicalValues[i - 1];
            totalGrowth += periodGrowth;
            i++;
        }
        return totalGrowth / (historicalValues.length - 1);
    }
    public static double[] predictValueSeries(double initialValue, double growthRate, int periods) {
        double[] predictions = new double[periods];
        if (periods > 0) {
            predictions[0] = initialValue * (1 + growthRate);
        }
        int i = 1;
        while (i < periods) {
            predictions[i] = predictions[i - 1] * (1 + growthRate);
            i++;
        }
        return predictions;
    }
}
