import java.util.*;

public class LootBox_01 {
    public static void main(String[] args) {

        Scanner term = new Scanner(System.in);
        int sumOfEven = 0;

        int[] input = Arrays.stream(term.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        for (int num : input) {
            firstLootBox.offer(num);
        }

        input = Arrays.stream(term.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        for (int num : input) {
            secondLootBox.push(num);
        }
        // това е четенето на стек и опашка
        int first = 0;
        int second = 0;
        int currentSum = 0;
        while (!firstLootBox.isEmpty() || !secondLootBox.isEmpty()){
            if (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()){
                first = firstLootBox.peek();
                second = secondLootBox.pop();
                currentSum = first + second;

            } else {
                break;
            }
            if (!firstLootBox.isEmpty() || !secondLootBox.isEmpty()) {
                if (currentSum % 2 == 0) {
                    sumOfEven = sumOfEven + currentSum;
                    firstLootBox.poll();

                } else {
                    firstLootBox.offer(second);
                }
            } else {
                break;
            }
        }
        if (firstLootBox.isEmpty()){
            System.out.println("First lootbox is empty");
        } else if (secondLootBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }

        if (sumOfEven >= 100){
            System.out.println(String.format("Your loot was epic! Value: %d", sumOfEven));
        } else {
            System.out.println(String.format("Your loot was poor... Value: %d", sumOfEven));
        }
    }
}
