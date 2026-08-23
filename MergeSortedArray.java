//5.WAP TO MERGE TWO SORTED ARRAY[5 6 10 16 21] [1 4 7 14 17]

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] a = {5, 6, 10, 16, 21};
        int[] b = {1, 4, 7, 14, 17};

        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }

            k++;
        }

        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }

        // Display merged array
        System.out.println("Merged Sorted Array:");

        for (int x : c) {
            System.out.print(x + " ");
        }
    }
}