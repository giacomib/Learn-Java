package Chapter7;
public class Fibonacci {
    
    public int fibonacci(int n) {
        if(n == 0)
            return n;
        if(n == 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}