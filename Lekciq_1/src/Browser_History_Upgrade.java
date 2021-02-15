import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser_History_Upgrade {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String input = term.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!"Home".equals(input)){
            if (input.equals("back")){
                if (stack.size() == 1 || stack.isEmpty()){
                    System.out.println("no previous URLs");
                } else {
                    String current = stack.pop();
                    System.out.println(stack.peek());
                    queue.addFirst(current);
                }
            } else if (input.equals("forward")){
                if (queue.isEmpty()){
                    System.out.println("no next URLs");
                    queue.clear();
                } else {
                    String current = queue.poll();
                    System.out.println(current);
                    stack.push(current);
                }
            } else {
                stack.push(input);
                queue.clear();
                System.out.println(stack.peek());
            }

            input = term.nextLine();
        }
    }
}
