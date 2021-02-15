import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Maximum_Element {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int countCommands = Integer.parseInt(term.nextLine());

        for (int i = 0; i < countCommands; i++) {
            String[] command = term.nextLine().split("\\s+");

            switch (command[0]){
                case "1":
                    int current = Integer.parseInt(command[1]);
                    stack.push(current);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
