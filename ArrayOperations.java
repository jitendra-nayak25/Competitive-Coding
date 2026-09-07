import java.util.Scanner;

public class ArrayOperations {

    static int[] arr = new int[100];
    static int size = 0;

    // Display
    static void display() {
        if (size == 0) {
            System.out.println("Array is empty");
            return;
        }

        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Insert
    static void insert(int position, int value) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        for (int i = size; i > position; i--) {
            arr[i] = arr[i - 1];
        }

        arr[position] = value;
        size++;

        System.out.println("Element inserted successfully");
    }

    // Delete
    static void delete(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return;
        }

        for (int i = position; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;

        System.out.println("Element deleted successfully");
    }

    // Search
    static void search(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }

        System.out.println("Element not found");
    }

    // Update
    static void update(int position, int value) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position");
            return;
        }

        arr[position] = value;

        System.out.println("Element updated successfully");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- ARRAY OPERATIONS ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Display");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter position: ");
                    int insertPosition = sc.nextInt();

                    System.out.print("Enter value: ");
                    int insertValue = sc.nextInt();

                    insert(insertPosition, insertValue);
                    break;

                case 2:
                    System.out.print("Enter position: ");
                    int deletePosition = sc.nextInt();

                    delete(deletePosition);
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int searchValue = sc.nextInt();

                    search(searchValue);
                    break;

                case 4:
                    System.out.print("Enter position: ");
                    int updatePosition = sc.nextInt();

                    System.out.print("Enter new value: ");
                    int updateValue = sc.nextInt();

                    update(updatePosition, updateValue);
                    break;

                case 5:
                    display();
                    break;

                case 6:
                    System.out.println("Program terminated");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}