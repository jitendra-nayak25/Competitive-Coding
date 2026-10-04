public class MissingNumber {
    public static void main(String[] args) {

        int[] arr = {3, 0, 1};

        int n = arr.length;

        int total = n * (n + 1) / 2;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        int missing = total - sum;

        System.out.println("Missing Number: " + missing);
    }
}