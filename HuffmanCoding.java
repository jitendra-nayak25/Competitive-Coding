import java.util.*;

public class HuffmanCoding {

    // Node of Huffman Tree
    static class Node {
        char character;
        int frequency;

        Node left;
        Node right;

        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        Node(int frequency, Node left, Node right) {
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }

    // Generate Huffman codes
    static void generateCodes(Node root, String code) {

        if (root == null) {
            return;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            System.out.println(root.character + " : " + code);
            return;
        }

        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    public static void main(String[] args) {

        char[] characters = {
            'A', 'B', 'C', 'D', 'E', 'F'
        };

        int[] frequencies = {
            5, 9, 12, 13, 16, 45
        };

        // Min Heap
        PriorityQueue<Node> pq =
            new PriorityQueue<>(
                (a, b) -> a.frequency - b.frequency
            );

        // Add all characters to heap
        for (int i = 0; i < characters.length; i++) {

            pq.add(
                new Node(
                    characters[i],
                    frequencies[i]
                )
            );
        }

        // Build Huffman Tree
        while (pq.size() > 1) {

            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(
                left.frequency + right.frequency,
                left,
                right
            );

            pq.add(parent);
        }

        // Root of Huffman Tree
        Node root = pq.poll();

        System.out.println("Huffman Codes:");

        generateCodes(root, "");
    }
}