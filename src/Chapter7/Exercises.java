package Chapter7;

public class Exercises {
    
    public static void metodo1(int numero) {
        if(numero > 0) {
            metodo1(numero / 2);
            System.out.print(numero % 2 + "");
        }
    }

    public static int potenza(int n, int m) {
        if(m == 0)
            return 1;
        else
            return ( n * potenza(n, m-1) );
    }

    public static void metodo2(int n) {
        if(n > 0) {
            int d = n % 10;
            boolean dispari = (n/10) % 2 == 1;
            metodo2(n / 10);
            if(dispari)
                System.out.println(d / 2 + 5);
            else
                System.out.println(d / 2);
        }
    }

    // exercise 3
    public static int nCifreDispRic(int n) {
        if(n < 10) {
            if(n % 2 == 1)
                return 1;
            return 0;
        }
        if(n % 2 == 1)
            return nCifreDispRic(n / 10) + 1;
        return nCifreDispRic(n / 10);
    }

    // exercise 4
    public static int cifSumPosRic(int n) {
        if(n < 10)
            return n;
        return (n % 10) + cifSumPosRic(n / 10);
    }

    // exercise 5
    public static int calcolaDieciAlla(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        return 10 * calcolaDieciAlla(n-1);
    }

    // ex6 sum of the numbers in the input array
    public static int sumOfArray(int[] array, int left, int right) {
        
        int middle = (left + right) / 2;

        if(left > right)
            return 0;
        
        if(left == right)
            return array[left];
        
        return sumOfArray(array, left, middle) + sumOfArray(array, middle + 1, right);
    }

    // ex7 return the maximum value in the array, with a recursive function
    public static int maxValue(int[] inputArray, int l, int r) {
        if(l > r)
            return -1;

        int m = (l + r) / 2;
        
        if(l == r)
        return inputArray[l];
    
        if ((r-l) == 1)
        if(inputArray[l] > inputArray[r])
            return inputArray[l];
        else
            return inputArray[r];
        
        return Math.max( maxValue(inputArray, l, m), maxValue(inputArray, m+1, r));
    }

    // ex8 ricerca ternaria
    public static int ternarySearch(int[] inputArray, int value, int l, int r) {
        if(l > r)
            return -1;
        
        if(l == r && inputArray[l] == value)
            return l;
        
        int m1 = (l + r) / 3;
        int m2 = (l + r) * 2 / 3;
        
        if(inputArray[m1] == value)
            return m1;
        
        if(inputArray[m2] == value)
            return m2;
        
        if(value < inputArray[m1])
            return ternarySearch(inputArray, value, l, m1);
        
        if(value > inputArray[m2])
            return ternarySearch(inputArray, value, m2, r);
        
        //caso in cui il valore da ricercare si trova in mezzo alle due soglie
        return ternarySearch(inputArray, value, m1+1, m2-1);
        
    }

    // ex9 cumulative sums calculator
    public static int[] cumulativeSums(int[] inputArray, int pos) {
        int[] result;
        
        result = new int[inputArray.length];

        if(pos == 0) {
            result[0] = inputArray[0];
            return result;
        }
        
        result = cumulativeSums(inputArray, pos - 1);
        result[pos] = inputArray[pos] + result[pos - 1];
        
        return result;
    }
}
