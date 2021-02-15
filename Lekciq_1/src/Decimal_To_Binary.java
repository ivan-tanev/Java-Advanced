import java.util.ArrayDeque;
import java.util.Scanner;

public class Decimal_To_Binary {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int input = Integer.parseInt(term.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (input == 0){
            System.out.println("0");
        } else {
            while (input != 0) {
                stack.push(input % 2);
                input = input / 2;
            }
        }
        for (Integer integer : stack) {
            System.out.print(integer);
        }
    }
}
