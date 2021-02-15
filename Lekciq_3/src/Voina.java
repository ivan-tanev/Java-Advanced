import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays.stream(term.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondDeck = Arrays.stream(term.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 50;
        while (round > 0){
            int firstCard = firstDeck.iterator().next();
            firstDeck.remove(firstCard);
            int secondCard = secondDeck.iterator().next();
            secondDeck.remove(secondCard);
            if (firstCard > secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard){
                secondDeck.add(secondCard);
                secondDeck.add(firstCard);
            }

            round--;
        }

        if (firstDeck.size() > secondDeck.size()){
            System.out.println("First Player Win!");
        } else if (secondDeck.size() > firstDeck.size()){
            System.out.println("Second Player Win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
