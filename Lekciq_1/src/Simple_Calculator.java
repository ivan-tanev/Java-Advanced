import java.util.ArrayDeque;
import java.util.Scanner;

public class Simple_Calculator {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String input = term.nextLine();
        String[] calculator = input.split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = calculator.length - 1; i >= 0; i--) {
            stack.push(calculator[i]);
        }

        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            char operatop = stack.pop().charAt(0);
            int secondNumber = Integer.parseInt(stack.pop());
            int sum = 0;

            if (operatop == '+'){
                sum = firstNumber + secondNumber;
                stack.push(sum + "");
            } else if (operatop == '-') {
                sum = (firstNumber - secondNumber);
                stack.push(sum + "");
            }
        }

        System.out.println(stack.pop());
    }
}
