package Chapter6;

// exercise section - n1
public class NumeriSottoLaMedia {

    public static double average(int[] array) {
        int sum = 0;
        double average;

        for (int element : array) {
            sum += element;
        }
        average = ((double) sum) / array.length;
        return average;
    }

    public static int daysNumbUnderAve(int[] array) {
        int nDaysUnderAverage = 0;
        double average = average(array);

        for (int element : array) {
            if(element < average)
                nDaysUnderAverage++;
        }
        return nDaysUnderAverage;
    }
}
