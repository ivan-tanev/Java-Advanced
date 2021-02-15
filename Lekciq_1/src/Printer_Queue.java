import java.util.ArrayDeque;
import java.util.Scanner;

public class Printer_Queue {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String input = term.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (queue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n",queue.poll());
                }
            } else {
                queue.offer(input);
            }

            input = term.nextLine();
        }
        for (String device : queue) {
            System.out.println(device);
        }
    }
}
