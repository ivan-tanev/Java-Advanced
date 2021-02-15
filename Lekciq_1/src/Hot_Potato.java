import java.util.ArrayDeque;
import java.util.Scanner;

public class Hot_Potato {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String[] names = term.nextLine().split(" ");
        int step = Integer.parseInt(term.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String name : names) {
            queue.offer(name);
        }

        int cycle = 1;
        while (queue.size() > 1){
            for (int i = 1; i < step; i++) {
                String current = queue.poll();
                queue.offer(current);
            }
            if (IsPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean IsPrime(int n)
    {
        boolean primeCheck = true;
        if (n == 0 || n == 1)
        {
            primeCheck = false;
            return primeCheck;
        }
        else
        {
            for (int i = 2; i <= Math.sqrt(n); i++)
            {
                if (n % i == 0)
                {
                    primeCheck = false;
                }
            }
            return primeCheck;
        }
    }
}
