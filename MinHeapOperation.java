public class MinHeapOperation {

    int[] heap = new int[100];
    int size = 0;

    // Insert operation
    void insert(int value) {

        heap[size] = value;
        int i = size;
        size++;

        // Move element upward
        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap[i] < heap[parent]) {
                int temp = heap[i];
                heap[i] = heap[parent];
                heap[parent] = temp;

                i = parent;
            } else {
                break;
            }
        }
    }

    // Get minimum element
    void getMin() {
        if (size == 0) {
            System.out.println("Heap is empty");
        } else {
            System.out.println("Minimum element: " + heap[0]);
        }
    }

    // Delete minimum element
    void deleteMin() {

        if (size == 0) {
            System.out.println("Heap is empty");
            return;
        }

        System.out.println("Deleted: " + heap[0]);

        heap[0] = heap[size - 1];
        size--;

        // Move element downward
        int i = 0;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != i) {
                int temp = heap[i];
                heap[i] = heap[smallest];
                heap[smallest] = temp;

                i = smallest;
            } else {
                break;
            }
        }
    }

    // Display heap
    void display() {
        System.out.println("Heap elements:");

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        MinHeapOperation h = new MinHeapOperation();

        h.insert(30);
        h.insert(10);
        h.insert(20);
        h.insert(5);
        h.insert(40);

        h.display();

        h.getMin();

        h.deleteMin();

        h.display();

        h.getMin();
    }
}