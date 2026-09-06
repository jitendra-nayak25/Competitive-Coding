public class PairwiseSwap {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Pairwise swap
    static Node pairwiseSwap(Node head) {

        Node current = head;

        while (current != null && current.next != null) {

            // Swap data of two adjacent nodes
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;

            // Move to next pair
            current = current.next.next;
        }

        return head;
    }

    // Display linked list
    static void display(Node head) {

        Node current = head;

        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        // Create linked list
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Before Pairwise Swap:");
        display(head);

        head = pairwiseSwap(head);

        System.out.println("After Pairwise Swap:");
        display(head);
    }
}