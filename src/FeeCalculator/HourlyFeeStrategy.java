package FeeCalculator;

public class HourlyFeeStrategy implements FeeCalculatorStategy{
    @Override
    public double calculateFee(long entryTime, long exitTime) {
        long duration = exitTime - entryTime;
        long hours = (long) Math.ceil(duration / (1000.0 * 60 * 60));
        return hours * 50;
    }
}
