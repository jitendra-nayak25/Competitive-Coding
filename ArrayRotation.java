//4.WAP TO ROTATE 4-TIME AND DISPALY THE RESULT [1 6 7 8 9 5 16 15 13 17] 



public class ArrayRotation {

    public static void main(String[] args) {

        int[] arr = {1, 6, 7, 8, 9, 5, 16, 15, 13, 17};

        int n = arr.length;
        int k = 4;

        System.out.println("Original Array:");

        for (int x : arr) {
            System.out.print(x + " ");
        }

    
        for (int r = 1; r <= k; r++) {

            int last = arr[n - 1];

            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }

            arr[0] = last;
        }

        System.out.println("\n\nArray after 4 rotations:");

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}