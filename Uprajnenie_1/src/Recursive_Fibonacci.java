import java.util.Scanner;

public class Recursive_Fibonacci {
    public static long[] memoryForFibonacci;

    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        memoryForFibonacci = new long [n + 1];
        System.out.println(fib(n));

    }
    public static long fib(int n){
        if (n <= 1){
            return 1;
        }

        if (memoryForFibonacci[n] != 0){
            return memoryForFibonacci[n];
        }

        return memoryForFibonacci[n] = fib(n - 1) + fib(n - 2);
    }
}
