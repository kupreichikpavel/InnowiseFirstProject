package main.com.innowise.singleton;


public class EntityParametrs {
    private final int sum;
    private final int min;
    private final int max;
    private final int average;

    public EntityParametrs(int sum, int min, int max, int average) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.average = average;
    }

    public int getSum() {
        return sum;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getAverage() {
        return average;
    }


    @Override
    public String toString() {
        return "EntityParametrs{" +
                "sum=" + sum +
                ", min=" + min +
                ", max=" + max +
                ", average=" + average +
                '}';
    }
}
