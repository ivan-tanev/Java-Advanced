import java.util.ArrayDeque;
import java.util.Scanner;

public class Balanced_Parentheses {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        ArrayDeque<Character> closeBrackets = new ArrayDeque<>();

        String input = term.nextLine();
        boolean isEqual = true;

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == '[' || current == '{'){
                openBrackets.push(current);
            } else if (current == ')' || current == ']' || current == '}'){
                if (openBrackets.isEmpty()){
                    isEqual = false;
                    break;
                }
                char open = openBrackets.pop();
                if (current == ')' && open != '(') {
                    isEqual = false;
                } else if (current == ']' && open != '[') {
                    isEqual = false;
                } else if (current == '}' && open != '{') {
                    isEqual = false;
                }
            }
        }

        if (isEqual) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
