import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchUnsorted {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {50, 20, 70, 10, 40, 30, 60};

        System.out.print("The Elements are: ");
        for(int s = 0; s < arr.length; s++){
            System.out.println(arr[s]+" ");
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        // Sort the unsorted array
        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;
        boolean found = false;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                System.out.println("Element found at index: " + mid);
                found = true;
                break;
            }
            else if (key < arr[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        if (!found) {
            System.out.println("Element not found");
        }

        sc.close();
    }
}