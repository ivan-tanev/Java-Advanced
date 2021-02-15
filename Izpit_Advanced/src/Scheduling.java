import java.util.*;
import java.util.stream.Collectors;

public class Scheduling {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(term.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks ::push);

        ArrayDeque<Integer> threads  = Arrays.stream(term.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int valueOfTheTaskToKill = Integer.parseInt(term.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()){
            int taskValue = tasks.peek();
            int threadValue = threads.peek();

            if (threadValue >= taskValue){
                if (taskValue == valueOfTheTaskToKill){

                    System.out.println(String.format("Thread with value %d killed task %d", threads.peek(), tasks.pop()));
                    for (Integer thread : threads) {
                        System.out.print(thread + " ");
                    }
                    break;
                } else {
                    threads.poll();
                    tasks.pop();

                }

            } else {
                if (taskValue == valueOfTheTaskToKill){

                    System.out.println(String.format("Thread with value %d killed task %d", threads.peek(), tasks.pop()));
                    for (Integer thread : threads) {
                        System.out.print(thread + " ");
                    }
                    break;
                } else {
                    threads.poll();

                }
            }
        }
    }
}
