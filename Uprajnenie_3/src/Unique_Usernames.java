import java.util.LinkedHashSet;
import java.util.Scanner;

public class Unique_Usernames {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String input = term.nextLine();

            usernames.add(input);
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
