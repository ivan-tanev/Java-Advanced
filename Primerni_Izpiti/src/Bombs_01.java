import java.util.*;
import java.util.stream.Collectors;

public class Bombs_01 {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        ArrayDeque<Integer> effects = Arrays.stream(term.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> casings = new ArrayDeque<>();
        Arrays.stream(term.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(casings::push);

        Map<String, Integer> bombs = new TreeMap<>();
        String firstBomb = "Datura Bombs";
        String secondBomb = "Cherry Bombs";
        String thirdBomb = "Smoke Decoy Bombs";
        bombs.put(firstBomb, 0);
        bombs.put(secondBomb, 0);
        bombs.put(thirdBomb, 0);

        while (!effects.isEmpty() && !casings.isEmpty()){

            if (hasAllBombs(bombs, firstBomb, secondBomb, thirdBomb)){
                break;
            }

            int effect = effects.peek();
            int casing = casings.pop();
            int sum = effect + casing;

            if (sum == 40){
                effects.poll();
                bombs.put(firstBomb, bombs.get(firstBomb) + 1);
            } else if (sum == 60){
                effects.poll();
                bombs.put(secondBomb, bombs.get(secondBomb) + 1);
            } else if (sum == 120){
                effects.poll();
                bombs.put(thirdBomb, bombs.get(thirdBomb) + 1);
            } else {
                casings.push(casing - 5);
            }
        }

        if (hasAllBombs(bombs, firstBomb,secondBomb, thirdBomb)){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effects.isEmpty()){
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            String effectOutput = effects.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(effectOutput);
        }

        if (casings.isEmpty()){
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            String casingOutput = casings.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println(casingOutput);
        }

        for (Map.Entry<String, Integer> bomb : bombs.entrySet()) {
            System.out.println(String.format("%s: %d", bomb.getKey(), bomb.getValue()));
        }

    }
    private static boolean hasAllBombs(Map<String, Integer> bombs, String firstBomb, String secondBomb, String thirdBomb){
        return bombs.get(firstBomb) >= 3 && bombs.get(secondBomb) >= 3 && bombs.get(thirdBomb) >= 3;
    }
}
