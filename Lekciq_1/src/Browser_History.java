import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser_History {
    public static void main(String[] args) {
        Scanner term = new Scanner(System.in);

        String input = term.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!"Home".equals(input)){
            if (input.equals("back")){
                if (stack.size() == 1 || stack.isEmpty()){
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else {
                stack.push(input);
                System.out.println(stack.peek());
            }

            input = term.nextLine();
        }
    }
}
