import java.util.Scanner;

public class LinkedListOperations {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    // Insert at beginning
    static void insertBeginning(int data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        System.out.println("Element inserted at beginning.");
    }

    // Insert at end
    static void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            System.out.println("Element inserted at end.");
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        System.out.println("Element inserted at end.");
    }

    // Insert at specific position
    static void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            insertBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Element inserted at position " + position);
    }

    // Delete from beginning
    static void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Deleted: " + head.data);

        head = head.next;
    }

    // Delete from end
    static void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            System.out.println("Deleted: " + head.data);
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        System.out.println("Deleted: " + temp.next.data);

        temp.next = null;
    }

    // Delete from specific position
    static void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (position < 1) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            deleteBeginning();
            return;
        }

        Node temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Position out of range.");
            return;
        }

        System.out.println("Deleted: " + temp.next.data);

        temp.next = temp.next.next;
    }

    // Search element
    static void search(int data) {
        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == data) {
                System.out.println(
                        "Element " + data + " found at position " + position
                );
                return;
            }

            temp = temp.next;
            position++;
        }

        System.out.println("Element not found.");
    }

    // Count nodes
    static void countNodes() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Number of nodes: " + count);
    }

    // Reverse linked list
    static void reverse() {
        Node previous = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;

        System.out.println("Linked list reversed.");
    }

    // Display linked list
    static void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        System.out.print("Linked List: ");

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice, data, position;

        while (true) {

            System.out.println("\n===== LINKED LIST OPERATIONS =====");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Search");
            System.out.println("8. Count Nodes");
            System.out.println("9. Reverse");
            System.out.println("10. Display");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    insertBeginning(data);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    insertEnd(data);
                    break;

                case 3:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();

                    System.out.print("Enter position: ");
                    position = sc.nextInt();

                    insertAtPosition(data, position);
                    break;

                case 4:
                    deleteBeginning();
                    break;

                case 5:
                    deleteEnd();
                    break;

                case 6:
                    System.out.print("Enter position: ");
                    position = sc.nextInt();

                    deleteAtPosition(position);
                    break;

                case 7:
                    System.out.print("Enter element to search: ");
                    data = sc.nextInt();

                    search(data);
                    break;

                case 8:
                    countNodes();
                    break;

                case 9:
                    reverse();
                    break;

                case 10:
                    display();
                    break;

                case 11:
                    System.out.println("Program terminated.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}