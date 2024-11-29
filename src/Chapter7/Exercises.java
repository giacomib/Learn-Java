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

    public static int cifSumPosRic(int n) {
        if(n < 10)
            return n;
        return (n % 10) + cifSumPosRic(n / 10);
    }
}
