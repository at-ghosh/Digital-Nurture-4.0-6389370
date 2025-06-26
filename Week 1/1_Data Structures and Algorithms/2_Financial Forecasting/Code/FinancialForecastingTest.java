public class FinancialForecastingTest {
    public static void main(String[] args) {
        double[] historicalRevenue = { 12.5, 13.2, 14.1, 15.0, 16.3 };
        double avgGrowthRate = FinancialDataAnalyzer.calculateAverageGrowthRate(historicalRevenue);
        double currentValue = historicalRevenue[historicalRevenue.length - 1];
        int forecastPeriods = 5;
        double[] results = new double[3];
        results[0] = runTailRecursive(currentValue, avgGrowthRate, forecastPeriods);
        results[1] = runOptimized(currentValue, avgGrowthRate, forecastPeriods);
        results[2] = runRecursive(currentValue, avgGrowthRate, forecastPeriods);
        System.out.printf("\nSummary for period %d:\nTail Recursive: $%.2fM\nOptimized: $%.2fM\nRecursive: $%.2fM\n",
            forecastPeriods, results[0], results[1], results[2]);
        printForecastSeries(currentValue, avgGrowthRate, forecastPeriods);
        runPerformanceTests();
        System.out.printf("\nAverage growth rate: %.2f%%\n", avgGrowthRate * 100);
    }
    private static double runRecursive(double currentValue, double avgGrowthRate, int forecastPeriods) {
        long startTime = System.nanoTime();
        double value = FinancialForecaster.calculateFutureValue(currentValue, avgGrowthRate, forecastPeriods);
        long endTime = System.nanoTime();
        System.out.printf("Recursive: $%.2fM (%d ns)\n", value, (endTime - startTime));
        return value;
    }
    private static double runOptimized(double currentValue, double avgGrowthRate, int forecastPeriods) {
        long startTime = System.nanoTime();
        double value = FinancialForecaster.calculateFutureValueOptimized(currentValue, avgGrowthRate, forecastPeriods);
        long endTime = System.nanoTime();
        System.out.printf("Optimized: $%.2fM (%d ns)\n", value, (endTime - startTime));
        return value;
    }
    private static double runTailRecursive(double currentValue, double avgGrowthRate, int forecastPeriods) {
        long startTime = System.nanoTime();
        double value = FinancialForecaster.calculateFutureValueTailRec(currentValue, avgGrowthRate, forecastPeriods);
        long endTime = System.nanoTime();
        System.out.printf("Tail Recursive: $%.2fM (%d ns)\n", value, (endTime - startTime));
        return value;
    }
    private static void printForecastSeries(double currentValue, double avgGrowthRate, int forecastPeriods) {
        System.out.println("\nForecast Series:");
        double[] forecastSeries = FinancialDataAnalyzer.predictValueSeries(currentValue, avgGrowthRate, forecastPeriods);
        for (int i = 0; i < forecastSeries.length; i++) {
            System.out.printf("  Period %d: $%.2fM\n", i + 1, forecastSeries[i]);
        }
    }
    private static void runPerformanceTests() {
        System.out.println("\nPerformance:");
        int[] periodsArr = {5, 10, 20, 1000};
        for (int periods : periodsArr) {
            System.out.printf("\nTesting %d periods:\n", periods);
            try {
                long start = System.nanoTime();
                FinancialForecaster.calculateFutureValue(100, 0.05, periods);
                long end = System.nanoTime();
                System.out.printf("  Recursive: %d ns\n", end - start);
            } catch (StackOverflowError e) {
                System.out.println("  Recursive: Stack overflow");
            }
            long start = System.nanoTime();
            FinancialForecaster.calculateFutureValueOptimized(100, 0.05, periods);
            long end = System.nanoTime();
            System.out.printf("  Optimized: %d ns\n", end - start);
            start = System.nanoTime();
            FinancialForecaster.calculateFutureValueTailRec(100, 0.05, periods);
            end = System.nanoTime();
            System.out.printf("  Tail recursive: %d ns\n", end - start);
        }
    }
}
