import Chapter6.*;
import Chapter7.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // testing chapter 6 classes

        //testing of OrdinaArray class
        int[] valori1 = new int[]{10, 15, 32, 2, 4, 23, 21, 10, 15, 32, 2, 4, 23, -21};
        int[] valori2 = new int[]{-10, 15, 32, 2, 4, 23, 21, 10, 15, 32, 2, 4, 23, -21};
        int[] valori3 = new int[]{10, 15, 32, 2, 4, -23, 21, 10, 15, 32, 2, 4, 23, -21};
        int[] valori4 = new int[]{0, 0, 0, 0, 0, 0, 1, 0};

        OrdinaArray.selectionSort(valori1);
        OrdinaArray.selectionSort(valori2);
        OrdinaArray.selectionSort(valori3);
        OrdinaArray.selectionSort(valori4);

        for(int elemento : valori1) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        for(int elemento : valori2)
            System.out.print(elemento + " ");
        System.out.println();

        for(int elemento : valori3)
            System.out.print(elemento + " ");
        System.out.println();

        for(int elemento : valori4)
            System.out.print(elemento + " ");
        System.out.println();
        System.out.println();

        //testing of NumeriSottoLaMedia class
        int[] valori5 = new int[]{10, 15, 16, 13, 15, 17 ,19, 9, 7, 10};
        System.out.println("number of days under the average: " + NumeriSottoLaMedia.daysNumbUnderAve(valori5));
        System.out.println();

        //testing of ContaFamiglie class
        double[] valori6 = new double[]{10, 15, 19, 16, 13, 15, 18 ,19, 9, 7, 10};
        double value = 13;
        double highest = ContaFamiglie.highestIncome(valori6);
        double highestLess10 = highest * 0.9;
        System.out.println("number of families with income lower than " + value + ": " + ContaFamiglie.countNumberUnderValue(valori6, value));
        System.out.println("highest income: " + highest);
        System.out.println("number of families with an income lower than the 90% of the value of the highest income: " + ContaFamiglie.countNumberUnder90(valori6));
        System.out.println("actual income values of the families that have an income lower than " + highestLess10);
        for (double element : valori6)
            if(element < highestLess10)
                System.out.print(element + " ");
        System.out.println();
        System.out.println();

        //Testing of OrdinaArray.rimuovi method
        int[] valori7 = new int[]{10, 15, 16, 13, 15, 17 ,19, 9, 7, 10};
        int [] result;

        System.out.println("current array: ");
        for (int element : valori7)
            System.out.println(element);
        System.out.println("array with rimuovi method applied with value = 15: ");
        result = OrdinaArray.rimuovi(valori7, 15);
        for (int element : result)
            System.out.println(element);
        System.out.println();

        //Testing of OrdinaArray.selectionSort on a characters array
        char[] arrayOfChar = new char[] {'a', 'c', 'b', 'f', 'r', 'a', 'l'};

        System.out.println("current array: ");
        for (char element : arrayOfChar)
            System.out.println(element);

        OrdinaArray.selectionSort(arrayOfChar);

        System.out.println("array with selectionSort method applied: ");
        for (char element : arrayOfChar)
            System.out.println(element);
        System.out.println();

        //Testing of OrdinaArray.partialSelectionSort
        System.out.println("current array: ");
        for (int element : valori7)
            System.out.println(element);
        System.out.println("array with partialSelectionSort method applied with start = 2, finish = 5: ");
        OrdinaArray.partialSelectionSort(valori7, 2, 5);
        for (int element : valori7)
            System.out.println(element);
        System.out.println();

        //Testing of OrdinaArray.sequentialSearch method
        int[] valori8 = new int[] {1, 3, 5, 6, 7, 8, 9, 12, 15};
        System.out.println("current array: ");
        for (int element : valori8)
            System.out.println(element);
        System.out.println("applying method sequentialSearch with value to search = 9: ");
        System.out.println(OrdinaArray.sequentialSearch(valori8, 9));
        System.out.println("applying method sequentialSearch with value to search = 11: ");
        System.out.println(OrdinaArray.sequentialSearch(valori8, 11));
        System.out.println();

        //Testing of OrdinaArray.findImage
        double[][] image1 = new double[][] {
                {1.2, 1.3, 4.5, 6.0, 2.7},
                {1.7, 3.3, 4.4, 10.5, 17.0},
                {1.1, 4.5, 2.1, 25.3, 9.2},
                {1.0, 9.5, 8.3, 2.9, 2.1}};

        System.out.println("current matrix: ");

        for (double[] row : image1) {
            for (double element : row)
                System.out.print(element + " ");
            System.out.println();
        }

        double [][] result1 = OrdinaArray.findImage(image1, 1.4);

        System.out.println("matrix result with threshold value of 1.4: ");

        for (double[] row : result1) {
            for (double element : row)
                System.out.print(element + " ");
            System.out.println();
        }

        double [][] result2 = OrdinaArray.findImage(image1, 0.6);

        System.out.println("matrix result with threshold value of 0.6: ");

        for (double[] row : result2) {
            for (double element : row)
                System.out.print(element + " ");
            System.out.println();
        }
        System.out.println();

        //Testing of OrdinaArray.blur
        double[][] image2 = new double[][] {
                {1.2, 1.3, 4.5, 6.0, 2.7},
                {1.7, 3.3, 4.4, 10.5, 17.0},
                {1.1, 4.5, 2.1, 25.3, 9.2},
                {1.0, 9.5, 8.3, 2.9, 2.1}};

        double[][] result3 = OrdinaArray.blur(image2);

        System.out.println("matrix resulting of blur method: ");

        for (double[] row : result3) {
            for (double element : row)
                System.out.print(element + " ");
            System.out.println();
        }
        System.out.println();

        //testing of OrdinaArray.bubbleSort method
        System.out.println("testing of OrdinaArray.bubbleSort method: ");
        int[] valori9 = new int[]{10, 15, 32, 2, 4, 23, 21, 10, 15, 32, 2, 4, 23, -21};
        int[] valori10 = new int[]{-10, 15, 32, 2, 4, 23, 21, 10, 15, 32, 2, 4, 23, -21};
        int[] valori11 = new int[]{10, 15, 32, 2, 4, -23, 21, 10, 15, 32, 2, 4, 23, -21};
        int[] valori12 = new int[]{0, 0, 0, 0, 0, 0, 1, 0};

        OrdinaArray.bubbleSort(valori9);
        OrdinaArray.bubbleSort(valori10);
        OrdinaArray.bubbleSort(valori11);
        OrdinaArray.bubbleSort(valori12);

        for(int elemento : valori9) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        for(int elemento : valori10) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        for(int elemento : valori11) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        for(int elemento : valori12) {
            System.out.print(elemento + " ");
        }
        System.out.println();
        System.out.println();

        //testing of OrdinaArray.insertionSort method
        System.out.println("testing of OrdinaArray.insertionSort method: ");
        int[] valori13 = new int[]{10, 15, 32, 2, 4, 23, 21, 10, 15, 32, 2, 4, 23, -21};
        int[] valori14 = new int[]{-10, 15, 32, 2, 4, 23, 21, 10, 15, 32, 2, 4, 23, -21};
        int[] valori15 = new int[]{10, 15, 32, 2, 4, -23, 21, 10, 15, 32, 2, 4, 23, -21};
        int[] valori16 = new int[]{0, 0, 0, 0, 0, 0, 1, 0};

        OrdinaArray.insertionSort(valori13);
        OrdinaArray.insertionSort(valori14);
        OrdinaArray.insertionSort(valori15);
        OrdinaArray.insertionSort(valori16);

        for(int elemento : valori13) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        for(int elemento : valori14) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        for(int elemento : valori15) {
            System.out.print(elemento + " ");
        }
        System.out.println();

        for(int elemento : valori16) {
            System.out.print(elemento + " ");
        }
        System.out.println();
        System.out.println();

        // testing chapter 7 classes
        
        // testing fibonacci
        Fibonacci myFibonacci = new Fibonacci();
        System.out.println("res: " + myFibonacci.fibonacci(8));
    }
    
}