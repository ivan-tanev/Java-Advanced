import java.util.Scanner;
import java.util.TreeSet;

public class SoftUni_Party {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);

        String input = term.nextLine();
        TreeSet<String> vips = new TreeSet<>();
        TreeSet<String> regulars = new TreeSet<>();

        while (!input.equals("PARTY")){
            char first = input.charAt(0);
            if (Character.isDigit(first)){
                vips.add(input);
            } else {
                regulars.add(input);
            }

            input = term.nextLine();
        }

        input = term.nextLine();

        while (!input.equals("END")){
            char first = input.charAt(0);
            if (Character.isDigit(first)){
                vips.remove(input);
            } else {
                regulars.remove(input);
            }

            input = term.nextLine();
        }

        System.out.println(vips.size() + regulars.size());

        if (vips.isEmpty()){
            for (String regular : regulars) {
                System.out.println(regular);
            }
        } else if (regulars.isEmpty()){
            for (String vip : vips) {
                System.out.println(vip);
            }
        } else {
            for (String vip : vips) {
                System.out.println(vip);
            }

            for (String regular : regulars) {
                System.out.println(regular);
            }
        }
    }
}
