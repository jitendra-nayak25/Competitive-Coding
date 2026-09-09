public class QueueOperations {

    static int[] queue = new int[5];
    static int front = -1;
    static int rear = -1;

    // Enqueue
    static void enqueue(int value) {
        if (rear == queue.length - 1) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1) {
                front = 0;
            }

            rear++;
            queue[rear] = value;
            System.out.println(value + " inserted");
        }
    }

    // Dequeue
    static void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(queue[front] + " deleted");
            front++;
        }
    }

    // Peek
    static void peek() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    // Display
    static void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue: ");

            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        enqueue(10);
        enqueue(20);
        enqueue(30);

        display();

        peek();

        dequeue();

        display();
    }
}