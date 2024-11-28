package Chapter6;

// exercise section - n2
public class ContaFamiglie {

    /**
     * compute the number of families that have an income lower than the threshold parameter
     * @param array array of incomes
     * @param threshold threshold value
     * @return the number of families that have an income lower than the threshold parameter
     */
    public static int countNumberUnderValue(double[] array, double threshold) {
        int sum = 0;

        for (double element : array) {
            if(element < threshold)
                sum++;
        }
        return sum;
    }

    /**
     * compute the highest income value
     * @param array array of incomes
     * @return the highest value
     */
    public static double highestIncome(double[] array) {
        double max = 0;
        for (double element : array) {
            if(element > max)
                max = element;
        }
        return max;
    }

    /**
     * compute the number of families that have an income lower than the 90% of the value of the highest income
     * @param array array of incomes
     * @return number of families that have an income lower than the 90% of the value of the highest income
     */
    public static int countNumberUnder90(double[] array) {
        double highest = highestIncome(array);
        double highestLess10 = highest * 0.9;
        return countNumberUnderValue(array, highestLess10);
    }
}
