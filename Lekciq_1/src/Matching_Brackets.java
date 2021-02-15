import java.util.ArrayDeque;
import java.util.Scanner;

public class Matching_Brackets {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String input = term.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '('){
                stack.push(i);
            }
            if (input.charAt(i) == ')'){
                String substring = input.substring(stack.pop(), i + 1);
                System.out.println(substring);
            }
        }
    }
}
