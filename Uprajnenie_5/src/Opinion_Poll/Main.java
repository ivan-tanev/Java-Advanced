package Opinion_Poll;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = term.nextLine().split("\\s+");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);

            if (age > 30){
                Person person = new Person(name, age);
                people.add(person);
            }
        }
        people.sort(Comparator.comparing(person -> person.name));

        for (Person person : people) {
            System.out.println(person.toString());
        }
    }
}
