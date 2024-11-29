package Chapter7;

public class Exercises {
    
    public static void metodo1(int numero) {
        if(numero > 0) {
            System.out.println(numero / 2);
            metodo1(numero / 2);
            System.out.println(numero % 2);
        }
    }
}
