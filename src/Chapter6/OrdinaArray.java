package Chapter6;

public class OrdinaArray {

    public static void selectionSort(int[] array) {
        for (int i = 0; i <= array.length - 2; i++) {
            int indiceValoreMinimo = indiceMinimo(i, array);
            if(i != indiceValoreMinimo)
                swap(array, i, indiceValoreMinimo);
        }
        assertSorting(array); //check correctness
    }

    public static int indiceMinimo(int inizio, int[] array) {
        int minimo = inizio;
        for (int i = inizio; i <= array.length - 1; i++) {
            if(array[i] < array[minimo]) {
                minimo = i;
            }
        }
        return minimo;
    }

    public static void assertSorting(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            assert array[i] <= array[i + 1];
        }
    }

    public static int[] rimuovi(int[] array, int v) {
        int count = 0;
        int [] output;

        for (int element : array) {
            if (element == v)
                count++;
        }
        if(count != 0) {
            output = new int[array.length - count];
            int usedCell = 0;
            for (int i = 0; i <= array.length - 1 && usedCell <= array.length - count - 1; i++) {
                if(array[i] != v) {
                    output[usedCell] = array[i];
                    usedCell++;
                }
            }
        } else
            return new int[0];
        return output;
    }

    public static void selectionSort(char[] array) {
        for (int i = 0; i <= array.length - 2; i++) {
            int indiceValoreMinimo = indiceMinimo(i, array);
            if(i != indiceValoreMinimo)
                scambiaValori(i, indiceValoreMinimo, array);
        }
        assertSorting(array); //check correctness
    }

    public static int indiceMinimo(int inizio, char[] array) {
        int minimo = inizio;
        for (int i = inizio; i <= array.length - 1; i++) {
            if(array[i] < array[minimo]) {
                minimo = i;
            }
        }
        return minimo;
    }

    public static void scambiaValori(int i, int indiceValoreMinimo, char[] array) {
        char tmp = array[i];
        array[i] = array[indiceValoreMinimo];
        array[indiceValoreMinimo] = tmp;
    }

    public static void assertSorting(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            assert array[i] <= array[i + 1];
        }
    }

    public static void partialSelectionSort(int[] array, int start, int finish) {
        assert(0 <= start && start <= finish);
        assert(finish <= array.length -1);
        for (int i = start; i <= finish; i++) {
            int indiceValoreMinimo = indiceMinimo(i, array);
            if(i != indiceValoreMinimo)
                swap(array, i, indiceValoreMinimo);
        }
        //should implement correctness check via assert
    }

    /**
     *
     * @param array The input array, it is assumed that the array is sorted in ascending order.
     * @param value The value to search in the input array.
     * @return The index of the array corresponding to the input value, if present.
     * If the array does not contain the value, then it will return -1;
     */
    public static int sequentialSearch(int[] array, int value) {
        for (int i = 0; i <= array.length - 1; i++) {
            if (value < array[i]) {
                return -1;
            } else if (value == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static double[][] findImage(double [][] array, double threshold) {
        double[][] outputArray = new double[array.length][array[0].length];
        int totNumOfValues = array.length * array[0].length;
        double sumOfAllValues = 0;
        double averageValue;

        for (double[] row : array) {
            for (double element : row) {
                sumOfAllValues += element;
            }
        }
        averageValue = sumOfAllValues / totNumOfValues;

        for (int row = 0; row <= array.length - 1; row++) {
            for (int column = 0; column <= array[0].length - 1; column++) {
                if(array[row][column] <= threshold * averageValue) {
                    outputArray[row][column] = 0.0;
                } else
                    outputArray[row][column] = 1.0;
            }
        }
        return outputArray;
    }

    //exercise section - n14
    //work in progress
    public static double[][] blur(double[][] immagine) {
        int imageNRows = immagine.length;
        int imageNColumns = immagine[0].length;
        double mulTmp;

        double[][] weights = new double[][] {
                {1, 2, 1},
                {2, 4, 2},
                {1, 2, 1}};
        int weightNRows = weights.length;
        int weightNColumns = weights[0].length;
        int weightMiddle = weightNRows / 2;

        int weightsSum;

        double[][] result = new double[imageNRows][imageNColumns];
        for (int i = 0; i <= imageNRows - 1; i++) {
            for (int j = 0; j <= imageNColumns - 1; j++) {
                result[i][j] = 0;
            }
        }

        for (int row = 0; row <= imageNRows - 1; row++) {
            for (int column = 0; column <= imageNColumns - 1; column++) {
                mulTmp = 0;
                weightsSum = 0;

                //top left angle
                if (row == 0 && column == 0) {
                    for (int weightRow = weightMiddle; weightRow <= weightNRows - 1; weightRow++) {
                        for (int weightColumn = weightMiddle; weightColumn <= weightNColumns - 1; weightColumn++) {
                            mulTmp = mulTmp + (immagine[row + weightRow - weightMiddle][column + weightColumn - weightMiddle] * weights[weightRow][weightColumn]);
                            weightsSum += (int) weights[weightRow][weightColumn];
                        }
                    }
                }

                //top right angle
                if (row == 0 && column == imageNColumns - 1) {
                    for (int weightRow = weightMiddle; weightRow <= weightNRows - 1; weightRow++) {
                        for (int weightColumn = 0; weightColumn <= weightMiddle; weightColumn++) {
                            mulTmp = mulTmp + (immagine[row + weightRow - 1][column + weightColumn - 1] * weights[weightRow][weightColumn]);
                            weightsSum += (int) weights[weightRow][weightColumn];
                        }
                    }
                }

                //bottom left angle
                if (row == imageNRows - 1 && column == 0) {
                    for (int weightRow = 0; weightRow <= weightMiddle; weightRow++) {
                        for (int weightColumn = weightMiddle; weightColumn <= weightNColumns - 1; weightColumn++) {
                            mulTmp = mulTmp + (immagine[row + weightRow - 1][column + weightColumn - weightMiddle] * weights[weightRow][weightColumn]);
                            weightsSum += (int) weights[weightRow][weightColumn];
                        }
                    }
                }

                //bottom right angle
                if (row == imageNRows - 1 && column == imageNColumns - 1) {
                    for (int weightRow = 0; weightRow <= weightMiddle; weightRow++) {
                        for (int weightColumn = 0; weightColumn <= weightMiddle; weightColumn++) {
                            mulTmp = mulTmp + (immagine[row + weightRow - weightMiddle][column + weightColumn - weightMiddle] * weights[weightRow][weightColumn]);
                            weightsSum += (int) weights[weightRow][weightColumn];
                        }
                    }
                }

                /*
                //on one of the angles
                if (row % (immagine.length - 1) == 0 && column % (immagine[0].length - 1) == 0) {

                }
                //first and last row without angles
                if (row % (immagine.length - 1) == 0 && column % (immagine[0].length - 1) != 0) {

                }
                //first and last column without angles
                if (row % (immagine.length - 1) != 0 && column % (immagine[0].length - 1) == 0) {

                }
                */

                //everything else
                if(row > 0 && row < imageNRows - 1 && column > 0 && column < imageNColumns - 1) {
                    for (int weightRow = -1; weightRow <= 1; weightRow++) {
                        for (int weightColumn = -1; weightColumn <= 1; weightColumn++) {
                            mulTmp =mulTmp +  weights[weightRow + 1][weightColumn + 1] * immagine[row + weightRow][column + weightColumn];
                            weightsSum += (int) weights[weightRow + 1][weightColumn + 1];
                        }
                    }
                }
                //da eseguire sempre
                result[row][column] = mulTmp / weightsSum;
            }
        }
        return result;
    }

    public static void bubbleSort(int[] array) {
        int arrayLength = array.length;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < arrayLength - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swap = true;
                }
            }
        } while (swap);
    }

    public static void insertionSort(int[] array) {
        int arrayLength = array.length;
        for (int i = 1; i <= arrayLength - 1; i++) {
            int value = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > value) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = value;
        }
    }

    public static void swap (int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
