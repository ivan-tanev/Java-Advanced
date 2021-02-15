import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Count_Symbols {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String input = term.nextLine();

        Map<Character, Integer> chars = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (chars.containsKey(current)){
                chars.put(current, chars.get(current) + 1);
            } else {
                chars.putIfAbsent(current, 1);
            }
        }

        chars.entrySet()
                .stream()
                .forEach(symbol -> {
                    System.out.println(String.format("%c: %d time/s", symbol.getKey(), symbol.getValue()));
                });
    }
}
