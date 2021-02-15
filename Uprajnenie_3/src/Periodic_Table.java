import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Periodic_Table {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        TreeSet<String> chemicalElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] elements = term.nextLine().split(" ");

            chemicalElements.addAll(Arrays.asList(elements));
        }

        System.out.println(String.join(" ", chemicalElements));
    }
}
