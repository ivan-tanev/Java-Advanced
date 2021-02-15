import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Basic_Stack_Operations {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        String [] input = term.nextLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] numbers = term.nextLine().split(" ");
        for (String number : numbers) {
            stackNumbers.push(Integer.parseInt(number));
        }

        for (int i = 0; i < s; i++) {
            stackNumbers.pop();
        }

        if (stackNumbers.isEmpty()){
            System.out.println(0);
        } else {
            if (stackNumbers.contains(x)){
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stackNumbers));
            }
        }
    }
}
