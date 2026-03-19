package main.com.innowise.arraymanager.singleton;


public class EntityParameters {
    private final int sum;
    private final int min;
    private final int max;
    private final int average;

    public EntityParameters(int sum, int min, int max, int average) {
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
    public final boolean equals(Object o) {
        if (!(o instanceof EntityParameters that)) return false;

        return sum == that.sum && min == that.min && max == that.max && average == that.average;
    }

    @Override
    public int hashCode() {
        int result = sum;
        result = 31 * result + min;
        result = 31 * result + max;
        result = 31 * result + average;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EntityParameters{");
        sb.append("sum=").append(sum);
        sb.append(", min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", average=").append(average);
        sb.append('}');
        return sb.toString();
    }
}
