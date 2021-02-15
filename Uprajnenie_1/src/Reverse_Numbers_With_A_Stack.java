import java.util.ArrayDeque;
import java.util.Scanner;

public class Reverse_Numbers_With_A_Stack {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String[] numbers = term.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
