import java.util.*;

public class Cities_By_Continent_And_Country {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        int n = Integer.parseInt(term.nextLine());
        Map<String, Map<String, List<String>>> continentsFull = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] parts = term.nextLine().split("\\s+");
            String continent = parts[0];
            String country = parts[1];
            String city = parts[2];

            continentsFull.putIfAbsent(continent, new LinkedHashMap<>());
            continentsFull.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsFull.get(continent).get(country).add(city);
        }

        continentsFull.entrySet()
                .stream()
                .forEach(continent -> {
                    System.out.println(continent.getKey() + ":");
                    continent.getValue().entrySet()
                            .stream()
                            .forEach(country -> {
                                System.out.printf("  %s -> %s%n", country.getKey(), String.join(", ",country.getValue()));
                            });
                });
    }
}
