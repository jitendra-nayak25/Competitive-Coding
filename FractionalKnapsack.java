import java.util.Arrays;

public class FractionalKnapsack {

    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };

        int capacity = 50;

        // Sort according to value/weight ratio
        Arrays.sort(items, (a, b) -> {

            double ratioA = (double) a.value / a.weight;
            double ratioB = (double) b.value / b.weight;

            return Double.compare(ratioB, ratioA);
        });

        double maximumValue = 0;

        for (Item item : items) {

            if (capacity >= item.weight) {

                // Take complete item
                capacity -= item.weight;
                maximumValue += item.value;

            } else {

                // Take fraction of item
                maximumValue +=
                    ((double) item.value / item.weight) * capacity;

                capacity = 0;

                break;
            }
        }

        System.out.println(
            "Maximum Value: " + maximumValue
        );
    }
}
