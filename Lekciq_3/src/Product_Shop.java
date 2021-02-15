import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Product_Shop {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String input = term.nextLine();
        Map<String, Map<String, Double>> stores = new TreeMap<>();

        while (!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String store = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            stores.putIfAbsent(store, new LinkedHashMap<>());
            stores.get(store).put(product, price);

            input = term.nextLine();
        }

        stores.entrySet()
                .stream()
                .forEach(store -> {
                    System.out.println(store.getKey() + "->");
                    store.getValue().entrySet()
                            .stream()
                            .forEach(product -> {
                                System.out.printf("Product: %s, Price: %.1f%n", product.getKey(), product.getValue());
                            });
                });
    }
}
