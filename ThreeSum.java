import java.util.*;

public class ThreeSum {

    public static ArrayList<ArrayList<Integer>> triplets(int[] arr) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int n = arr.length;

        // Sort the array
        Arrays.sort(arr);

        // Choose the first element
        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            // Two pointer approach
            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {

                    ArrayList<Integer> triplet = new ArrayList<>();

                    triplet.add(arr[i]);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);

                    result.add(triplet);

                    // Skip duplicate left values
                    while (left < right && arr[left] == arr[left + 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right && arr[right] == arr[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {

                    // Need a bigger value
                    left++;

                } else {

                    // Need a smaller value
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};

        ArrayList<ArrayList<Integer>> result = triplets(arr);

        System.out.println("Unique triplets:");

        for (ArrayList<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}