import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class Basic_Queue_Operations {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        ArrayDeque<Integer> queueNumbers = new ArrayDeque<>();
        String [] input = term.nextLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] numbers = term.nextLine().split(" ");
        for (String number : numbers) {
            queueNumbers.offer(Integer.parseInt(number));
        }

        for (int i = 0; i < s; i++) {
            queueNumbers.poll();
        }

        if (queueNumbers.isEmpty()){
            System.out.println(0);
        } else {
            if (queueNumbers.contains(x)){
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queueNumbers));
            }
        }
    }
}
