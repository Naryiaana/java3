package lesson1.generics;

public class Stats<E extends Number> {

    public static void main(String[] args) {
        Stats<Integer> integerStats = new Stats<>(1, 2, 3, 4, 5);
        Stats<Double> doubleStats = new Stats<>(1.7, 2.3, 3.1, 4.5, 5.1, -1.7);

        System.out.println(integerStats.sum());
        System.out.println(doubleStats.sum());
        System.out.println(integerStats.isSumEquals(doubleStats));

    }

    private boolean isSumEquals(Stats<?> stats) {
        return Math.abs(stats.sum() - this.sum()) < 0.0000001;
    }
    private E[] nums;

    public Stats(E... nums) {
        this.nums = nums;
    }

    public double sum() {
        double sum = 0;
        for (E num : nums) {
            sum += num.doubleValue();
        }

        return sum;
    }
}
